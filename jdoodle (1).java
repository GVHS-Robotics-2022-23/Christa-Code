package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

public class TeleOp extends OpMode
{
   public DcMotor FR, FL, BR, BL;
   public DcMotor IW, INW;
   public Servo arm;
   private double powerRY, powerRX, powerLX, powerLY, powerIM,powerINM;


   @Override
   public void init()
   {
       arm = hardwareMap.get(Servo.class, "arm");
       FR = hardwareMap.get(DcMotor.class, "FR");
       FL = hardwareMap.get(DcMotor.class, "FL");
       BR = hardwareMap.get(DcMotor.class, "BR");
       BL = hardwareMap.get(DcMotor.class, "BL");
       IW = hardwareMap.get(DcMotor.class, "IW");
       INW = hardwareMap.get(DcMotor.class, "INW");


       FR.setDirection(DcMotorSimple.Direction.REVERSE);
       FL.setDirection(DcMotorSimple.Direction.FORWARD);
       BR.setDirection(DcMotorSimple.Direction.FORWARD);
       BL.setDirection(DcMotorSimple.Direction.REVERSE);


       FR.setPower(0);
       FL.setPower(0);
       BR.setPower(0);
       BL.setPower(0);
       arm.setPosition(0.37);
   }


   @Override
   public void loop() {

       powerLX = gamepad1.left_stick_x;
       powerLY = gamepad1.left_stick_y;
       powerRX = gamepad1.right_stick_x;
       powerRY = gamepad1.right_stick_y;
       powerIM = gamepad1.left_trigger;
       powerINM = gamepad1.right_trigger;

               if (powerRY < -0.3 || powerRY > 0.3) {
               FR.setPower(powerRY);
               BR.setPower(powerRY);
               FL.setPower(powerRY);
               BL.setPower(powerRY);
           } else {
               FR.setPower(0);
               BR.setPower(0);
               FL.setPower(0);
               BL.setPower(0);
           }

           if (powerRX > 0.3 || powerRX < -0.3) {
               FR.setPower(powerRX);
               BR.setPower(powerRX);
               FL.setPower(powerRX);
               BL.setPower(powerRX);
           } else {
               FL.setPower(0);
               BL.setPower(0);
               FL.setPower(0);
               BL.setPower(0);
               arm.setPosition(0);
           }

       if (powerLY < -0.3 || powerLY > 0.3) {
           FR.setPower(powerLY);
           BR.setPower(powerLY);
           FL.setPower(powerLY);
           BL.setPower(powerLY);
       } else {
           FR.setPower(0);
           BR.setPower(0);
           FL.setPower(0);
           BL.setPower(0);
           
      if (powerLX > 0.3 || powerLX < -0.3) {
           FR.setPower(powerLX);
           BR.setPower(powerLX);
           FL.setPower(powerLX);
           BL.setPower(powerLX);
       } else {
           FL.setPower(0);
           BL.setPower(0);
           FL.setPower(0);
           BL.setPower(0);
           arm.setPosition(0);
       }

       if(gamepad1.dpad_up)
       {
           arm.setPosition(-1);
       }
       else{
           arm.setPosition(0);
       }
       if(gamepad1.dpad_down)
       {
           arm.setPosition(0.5);
       }
       else{
           arm.setPosition(0);
       }
       if(gamepad1.dpad_left)
       {
           arm.setPosition(-0.5);
       }
       else{
           arm.setPosition(0);
       }
       if(gamepad1.dpad_right)
       {
           arm.setPosition(1);
       }
       else{
           arm.setPosition(0);
       }

    if(powerIM > 0.4){
        IW.setPower(powerIM);
    }
    else if(powerIM < 0.4){
        IW.setPower(0);
    }
    if(powerINM > 0.4){
        INW.setPower(powerINM);
    }
    else if(powerINM < 0.4){
        INW.setPower(powerINM);
    }
       }
   }
