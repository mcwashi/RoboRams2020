package org.firstinspires.ftc.teamcode;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

//@TeleOp(name = "Staker", group = "Linear OpMode")
//@Disabled
public class Stacker2 extends LinearOpMode {

    private ElapsedTime runtime      = new ElapsedTime();

    private DcMotor leftTopDrive     = null;
    private DcMotor leftBottomDrive  = null;
    private DcMotor rightTopDrive    = null;
    private DcMotor rightBottomDrive = null;
    private DcMotor topRackRight     = null;
    private DcMotor topRackLeft      = null;
    private DcMotor slide            = null;
    private Servo   servo1;
    private Servo   servo2;
    private Servo   grMain;
    private Servo   grHold;

    @Override
    public void runOpMode() throws InterruptedException {

        leftTopDrive                 = hardwareMap.get(DcMotor.class, "motortl");
        rightTopDrive            = hardwareMap.get(DcMotor.class, "motorbl");
        rightBottomDrive     = hardwareMap.get(DcMotor.class, "motortr");
        leftBottomDrive  = hardwareMap.get(DcMotor.class, "motorbr");

        topRackLeft          = hardwareMap.get(DcMotor.class, "trLeft");
        topRackRight     = hardwareMap.get(DcMotor.class, "trRight");

        slide                = hardwareMap.get(DcMotor.class, "slide");

        servo1               = hardwareMap.get(Servo.class, "pullR");
        servo2           = hardwareMap.get(Servo.class, "pullL");

        grMain               = hardwareMap.get(Servo.class, "grMain");
        grHold           = hardwareMap.get(Servo.class, "grHold");

        servo1.setPosition(1);
        servo2.setPosition(-1);

        //grMain.setPosition(.7);
        grHold.setPosition(-1);

        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        leftTopDrive.setDirection(DcMotor.Direction.FORWARD);
        leftBottomDrive.setDirection(DcMotor.Direction.FORWARD);
        rightTopDrive.setDirection(DcMotor.Direction.REVERSE);
        rightBottomDrive.setDirection(DcMotor.Direction.REVERSE);

        // Tell the driver that initialization is complete.
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()){

            double leftBackPower;
            double leftFrontPower;
            double rightBackPower;
            double rightFrontPower;

            double drive        = -gamepad1.left_stick_y;
            double turn         = gamepad1.left_stick_x;
            double strafeRight  = gamepad1.right_trigger;
            double strafeLeft   = gamepad1.left_trigger;

            boolean liftSlide  = gamepad2.left_bumper;
            boolean dropSlide  = gamepad2.right_bumper;
            boolean pSlide     = gamepad2.y;
            boolean pSlideDown = gamepad2.x;
            boolean armServo   = gamepad2.b;
            boolean pully      = gamepad2.a;

            //boolean pully      = gamepad1.a;

            leftFrontPower   = Range.clip(drive + turn, -1.0, 1.0) ;
            leftBackPower    = Range.clip(drive + turn, -1.0, 1.0);
            rightFrontPower  = Range.clip(drive - turn, -1.0, 1.0);
            rightBackPower   = Range.clip(drive - turn, -1.0, 1.0);

            // wheels
            leftTopDrive.setPower(leftFrontPower);
            rightTopDrive.setPower(rightFrontPower);
            rightBottomDrive.setPower(rightBackPower);
            leftBottomDrive.setPower(leftBackPower);

            ////////////////////////////////////////////////////////////////////////////////////////
            //                                                                                    //
            //STRAFING LEFT                                                                       //
            //                                                                                    //
            ////////////////////////////////////////////////////////////////////////////////////////
            if (strafeLeft == 1.0) {

                leftTopDrive.setPower(1);
                leftBottomDrive.setPower(-1);
                rightTopDrive.setPower(-1);
                rightBottomDrive.setPower(1);

            }else{

                leftTopDrive.setPower(0);
                leftBottomDrive.setPower(0);
                rightTopDrive.setPower(0);
                rightBottomDrive.setPower(0);

            }

            ////////////////////////////////////////////////////////////////////////////////////////
            //                                                                                    //
            //STRAFING RIGHT                                                                      //
            //                                                                                    //
            ////////////////////////////////////////////////////////////////////////////////////////
            if (strafeRight == 1.0) {

                leftTopDrive.setPower(-1);
                leftBottomDrive.setPower(1);
                rightTopDrive.setPower(1);
                rightBottomDrive.setPower(-1);

            }

            ////////////////////////////////////////////////////////////////////////////////////////
            //                                                                                    //
            //Arm Lift                                                                            //
            //                                                                                    //
            ////////////////////////////////////////////////////////////////////////////////////////
            if(liftSlide){

                topRackRight.setPower(1);
                topRackLeft.setPower(-1);

            }else{

                topRackRight.setPower(0);
                topRackLeft.setPower(0);

            }

            ////////////////////////////////////////////////////////////////////////////////////////
            //                                                                                    //
            //Drop arm - TODO: GO SLOW!                                                           //
            //                                                                                    //
            ////////////////////////////////////////////////////////////////////////////////////////
            if(dropSlide){

                topRackRight.setPower(-1);
                topRackLeft.setPower(1);

            }else{

                topRackRight.setPower(0);
                topRackLeft.setPower(0);
            }

            ////////////////////////////////////////////////////////////////////////////////////////
            //                                                                                    //
            //Servo Arm Code                                                                      //
            //                                                                                    //
            ////////////////////////////////////////////////////////////////////////////////////////
            if(armServo){

                servo1.setPosition(-1);
                servo2.setPosition(1);

            }else{

                servo1.setPosition(1);
                servo2.setPosition(-1);

            }

            ////////////////////////////////////////////////////////////////////////////////////////
            //                                                                                    //
            //Hook Control                                                                        //
            //                                                                                    //
            ////////////////////////////////////////////////////////////////////////////////////////
            if(pully){

                grMain.setPosition(0);//right
                grHold.setPosition(1);

            }else{
                grMain.setPosition(1);
                grHold.setPosition(0);

            }

            ////////////////////////////////////////////////////////////////////////////////////////
            //                                                                                    //
            //Panel Slide - Forward | Back                                                        //
            //                                                                                    //
            ////////////////////////////////////////////////////////////////////////////////////////
            if (pSlide) {

                slide.setPower(1);

            }else{

                slide.setPower(0);

            }

            if (pSlideDown) {

                slide.setPower(-1);

            }else{

                slide.setPower(0);

            }

            // Show the elapsed game time and wheel power.
            //telemetry.addData("Status", "Run Time: " + runtime.toString());
            //telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftBackPower, rightBackPower, rightFrontPower, leftFrontPower);

        }
    }
}