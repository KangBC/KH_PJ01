package Singleton;

import Controller.BbsController;
import Controller.MemberController;
import Controller.serverController;

public class Singleton {

   private static Singleton single = new Singleton();
   public MemberController memCtrl;
   public BbsController bbsCtrl;
   public serverController serCtrl;

   private Singleton() {
      memCtrl = new MemberController();
      bbsCtrl = new BbsController();
      serCtrl = new serverController();
   }

   public static Singleton getInstance() {
      return single;
   }
}