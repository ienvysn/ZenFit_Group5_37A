/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package zenfit_group5_37a;

import database.*;
import view.SignUp;
import controller.SignUpController;
import controller.LoginController;

/**
 *
 * @author ACER
 */
public class ZenFit_Group5_37A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SignUp signUpForm = new SignUp();
        SignUpController controller = new SignUpController(signUpForm);
        controller.open();
    }

}
