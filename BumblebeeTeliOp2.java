package org.firstinspires.ftc.teamcode;

import android.app.AlertDialog;
import android.content.DialogInterface;

import com.qualcomm.ftccommon.ViewLogsActivity;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "BubbleBee TeleOp", group = "LinearOpMode")
//@Disabled
public class BumblebeeTeliOp2 extends LinearOpMode {

    private ElapsedTime runtime      = new ElapsedTime();
    private DcMotor ltPower          = null;
    private DcMotor lbPower          = null;
    private DcMotor rtPower          = null;
    private DcMotor rbPower          = null;
    private DcMotor armUP            = null;
    private DcMotor slider           = null;

    private Servo hRight;
    private Servo hLeft;

    private Servo armMain;
    private Servo armHold;



    @Override
    public void runOpMode() throws InterruptedException {

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        ltPower       = hardwareMap.get(DcMotor.class, "motortl");
        lbPower       = hardwareMap.get(DcMotor.class, "motorbl");
        rtPower       = hardwareMap.get(DcMotor.class, "motortr");
        rbPower       = hardwareMap.get(DcMotor.class, "motorbr");

        armUP         = hardwareMap.get(DcMotor.class, "arm");
        slider        = hardwareMap.get(DcMotor.class, "slider");

        hRight        = hardwareMap.get(Servo.class, "rHook");
        hLeft         = hardwareMap.get(Servo.class, "lHook");

        armMain       = hardwareMap.get(Servo.class, "aMain");
        armHold       = hardwareMap.get(Servo.class, "aHold");



        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        ltPower.setDirection(DcMotor.Direction.FORWARD);
        lbPower.setDirection(DcMotor.Direction.FORWARD);
        rtPower.setDirection(DcMotor.Direction.REVERSE);
        rbPower.setDirection(DcMotor.Direction.REVERSE);




        //armMain.setPosition(0);

        //armHold.setPosition(-1);

        hRight.setPosition(0);
        hLeft.setPosition(1);



        // Tell the driver that initialization is complete.
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()){

            double leftBackPower;
            double rightBackPower;
            double leftFrontPower;
            double rightFrontPower;
            double strafeRight  = gamepad1.left_trigger;
            double strafeLeft   = gamepad1.right_trigger;


            //old way of doing this
            double  left            = -gamepad1.left_stick_y;
            double  right             = gamepad1.right_stick_x;

            //left = -gamepad1.left_stick_y;
            //right = -gamepad1.right_stick_y;
            //robot.leftDrive.setPower(left);
            //robot.rightDrive.setPower(right);



            boolean armUpControl     = gamepad2.left_bumper;
            boolean armDownConroler  = gamepad2.right_bumper;
            boolean sliderPushControl= gamepad2.y;
            boolean sliderPushReturn = gamepad2.b;
            boolean armUse           = gamepad2.x;
            //Marcus added this
            boolean driverBringDown = gamepad1.a;



            leftFrontPower   = Range.clip(left + right, -1.0, 1.0) ;
            leftBackPower    = Range.clip(left + right, -1.0, 1.0);
            rightFrontPower  = Range.clip(left - right, -1.0, 1.0);
            rightBackPower   = Range.clip(left - right, -1.0, 1.0);



            //ltPower.setPower(leftFrontPower);
            //lbPower.setPower(leftBackPower);
            //rtPower.setPower(rightBackPower);
            //rbPower.setPower(rightFrontPower);

            ltPower.setPower(leftFrontPower);
            lbPower.setPower(leftBackPower);
            rtPower.setPower(rightFrontPower);
            rbPower.setPower(rightBackPower);


            ////////////////////////////////////////////////////////////////////////////////////////
            //                                                                                    //
            //STRAFING LEFT                                                                       //
            //                                                                                    //
            ////////////////////////////////////////////////////////////////////////////////////////
            if (strafeLeft == 1.0) {

                ltPower.setPower(1);
                lbPower.setPower(-1);
                rtPower.setPower(-1);
                rbPower.setPower(1);

            }else{

                ltPower.setPower(0);
                lbPower.setPower(0);
                rtPower.setPower(0);
                rbPower.setPower(0);

            }

            ////////////////////////////////////////////////////////////////////////////////////////
            //                                                                                    //
            //STRAFING RIGHT                                                                      //
            //                                                                                    //
            ////////////////////////////////////////////////////////////////////////////////////////
            if (strafeRight == 1.0) {

                ltPower.setPower(-1);
                lbPower.setPower(1);
                rtPower.setPower(1);
                rbPower.setPower(-1);

            }





            if(armUpControl){

                armUP.setPower(1);

            }else{

                armUP.setPower(0);
            }

            if (armDownConroler) {

                armUP.setPower(-1);

            }else{

                armUP.setPower(0);

            }

            if (sliderPushControl) {

                slider.setPower(-1);

            }else{

                slider.setPower(0);

            }

            if (sliderPushReturn) {

                slider.setPower(1);

            }else{

                slider.setPower(0);

            }
            if (armUse) {


                armMain.setPosition(1);
                //armMain.setPosition(2);
                sleep(500);
                armHold.setPosition(0);



            }else{

                armHold.setPosition(1);
                sleep(1000);
                armMain.setPosition(0);





            }


            if(driverBringDown){
                hRight.setPosition(1);
                hLeft.setPosition(0);
            }
            else{
                hRight.setPosition(0);
                hLeft.setPosition(1);
            }



            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftBackPower, rightBackPower, rightFrontPower, leftFrontPower);

        }

    }
}