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
   private double powerRY, powerRX, powerLX, powerLY, powerIM,powerINM, lf, rb, rf, lb;


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

        if (gamepad1.right_bumper || gamepad1.left_bumper)
       {
           powerLX = gamepad1.left_stick_x/2;
           powerLY = gamepad1.left_stick_y/2;
           powerRX = gamepad1.right_stick_x/2;
           powerRY = gamepad1.right_stick_y/2;
       }

       if (gamepad1.left_stick_x != 0)
       {
           lf = powerRY;
           rb = -powerRY;
           lb = powerRY;
           rf = -powerRY;

           FR.setPower(rf);
           FL.setPower(lf);
           BR.setPower(rb);
           BL.setPower(lb);
       }
       else
       {
           robotAngle = Math.atan2(powerRX, powerRY);
           telemetry.addData("Robot angle:", robotAngle);
           telemetry.update();

           PowerMultiplier = Math.sqrt((Math.pow(powerRX, 2) + Math.pow(powerRY, 2)));

           if(powerRX == 0 || powerRY == 0)
           {
               if (powerRY <= 1 && powerRX == 0)
               {
                   lf = powerRY;
                   rb = powerRY;
                   lb = powerRY;
                   rf = powerRY;

                   FR.setPower(rf);
                   FL.setPower(lf);
                   BR.setPower(rb);
                   BL.setPower(lb);
               }
               else if (powerRX <= 1 && powerRY == 0)
               {
                   lf = powerRX;
                   rb = powerRX;
                   lb = -powerRX;
                   rf = -powerRX;

                   FR.setPower(rf);
                   FL.setPower(lf);
                   BR.setPower(rb);
                   BL.setPower(lb);
               }
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
    FL = (PowerMultiplier*(Math.sin(robotAngle+(Math.PI/4))));
   BR = (PowerMultiplier*(Math.sin(robotAngle+(Math.PI/4))));
     BL = (PowerMultiplier*-1*Math.sin(robotAngle-(Math.PI/4)));
           FR = (PowerMultiplier*-1*Math.sin(robotAngle-(Math.PI/4)));

           FR.setPower(rf);
           FL.setPower(lf);
           BR.setPower(rb);
           BL.setPower(lb);

       }
   }
