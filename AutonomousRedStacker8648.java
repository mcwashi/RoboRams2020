package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

//@Autonomous(name="Autonomous Red 8648", group="Pushbot")
//@Disabled
public class AutonomousRedStacker8648 extends LinearOpMode {

    private ElapsedTime runtime      = new ElapsedTime();
    private DcMotor ltPower          = null;
    private DcMotor lbPower          = null;
    private DcMotor rtPower          = null;
    private DcMotor rbPower          = null;
    private DcMotor armUP            = null;
    private DcMotor slide           = null;

    private Servo hRight;
    private Servo hLeft;

    private Servo armMain;
    private Servo armHold;

    @Override
    public void runOpMode() {

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        ltPower       = hardwareMap.get(DcMotor.class, "motortl");
        lbPower       = hardwareMap.get(DcMotor.class, "motorbl");
        rtPower       = hardwareMap.get(DcMotor.class, "motortr");
        rbPower       = hardwareMap.get(DcMotor.class, "motorbr");

        //armUP         = hardwareMap.get(DcMotor.class, "arm");
        //slider        = hardwareMap.get(DcMotor.class, "slider");

        slide         = hardwareMap.get(DcMotor.class, "slide");

        hRight        = hardwareMap.get(Servo.class, "pullR");
        hLeft         = hardwareMap.get(Servo.class, "pullL");

        armMain       = hardwareMap.get(Servo.class, "grMain");
        armHold       = hardwareMap.get(Servo.class, "grHold");

        armMain.setPosition(1);
        armHold.setPosition(0);


//        servo1               = hardwareMap.get(Servo.class, "pullR");
//        servo2           = hardwareMap.get(Servo.class, "pullL");
//
//        grMain               = hardwareMap.get(Servo.class, "grMain");
//        grHold           = hardwareMap.get(Servo.class, "grHold");
//





        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        ltPower.setDirection(DcMotor.Direction.FORWARD);
        lbPower.setDirection(DcMotor.Direction.FORWARD);
        rtPower.setDirection(DcMotor.Direction.REVERSE);
        rbPower.setDirection(DcMotor.Direction.REVERSE);



        //armMain.setPosition(-.80);
        //armHold.setPosition(.95);

        //hRight.setPosition(0);
        //hLeft.setPosition(1);



        // Tell the driver that initialization is complete.
        telemetry.addData("Status", "Initialized");
        telemetry.update();



        waitForStart();



        //Go right
        ltPower.setPower(.5);
        lbPower.setPower(.5);
        rtPower.setPower(.5);
        rbPower.setPower(.5);
        sleep(1500);


        //stop
        rtPower.setPower(0);
        ltPower.setPower(0);
        rbPower.setPower(0);
        lbPower.setPower(0);
        sleep(1000);

        //Move Forward
        rtPower.setPower(-.5);
        ltPower.setPower(-.5);
        rbPower.setPower(.5);
        lbPower.setPower(.5);
        sleep(900);
//
        //stop
        rtPower.setPower(0);
        ltPower.setPower(0);
        rtPower.setPower(0);
        ltPower.setPower(0);
        sleep(1000);
//
//

        //clamp
        armMain.setPosition(0);
        armHold.setPosition(1);
        sleep(1000);
//
//        //stop
        rtPower.setPower(0);
        ltPower.setPower(0);
        rbPower.setPower(0);
        lbPower.setPower(0);
        sleep(1000);
//
//        //Move Back
        rtPower.setPower(.5);
        ltPower.setPower(.5);
        rbPower.setPower(-.5);
        lbPower.setPower(-.5);
        sleep(1700);
//
//
//
//        //stop
        rtPower.setPower(0);
        ltPower.setPower(0);
        rbPower.setPower(0);
        lbPower.setPower(0);
        sleep(1000);
//
//
//        //Move Back with a turn
        rtPower.setPower(-.75);
        ltPower.setPower(-.25);
        rbPower.setPower(-.75);
        lbPower.setPower(-.25);
        sleep(4000);
//
//        //stop
        rtPower.setPower(0);
        ltPower.setPower(0);
        rbPower.setPower(0);
        lbPower.setPower(0);
        sleep(1000);

//        //Go right
//        ltPower.setPower(.5);
//        lbPower.setPower(.5);
//        rtPower.setPower(.5);
//        rbPower.setPower(.5);
//        sleep(3500);
//
//        //stop
//        rtPower.setPower(0);
//        ltPower.setPower(0);
//        rbPower.setPower(0);
//        lbPower.setPower(0);
//        sleep(1000);
//

//
//
        //Move Forward
        rtPower.setPower(-.5);
        ltPower.setPower(-.5);
        rbPower.setPower(.5);
        lbPower.setPower(.5);
        sleep(1300);







        //stop
        rtPower.setPower(0);
        ltPower.setPower(0);
        rbPower.setPower(0);
        lbPower.setPower(0);
        sleep(1000);
//
//
//        //unclamp
        armMain.setPosition(1);
        armHold.setPosition(0);
        sleep(500);

        //        //stop
        rtPower.setPower(0);
        ltPower.setPower(0);
        rtPower.setPower(0);
        ltPower.setPower(0);
        sleep(1000);

//
//
//        //Go Right
        ltPower.setPower(.5);
        lbPower.setPower(.5);
        rtPower.setPower(.5);
        rbPower.setPower(.5);
        sleep(600);
//
//
//        //stop
        rtPower.setPower(0);
        ltPower.setPower(0);
        rtPower.setPower(0);
        ltPower.setPower(0);
        sleep(1000);
//
        hLeft.setPosition(.50);
        sleep(500);
//
//        //stop
        rtPower.setPower(0);
        ltPower.setPower(0);
        rtPower.setPower(0);
        ltPower.setPower(0);
        sleep(1000);
//
//
//
//
//        //backup
        rtPower.setPower(.5);
        ltPower.setPower(.5);
        rbPower.setPower(-.5);
        lbPower.setPower(-.5);
        sleep(1900);
//
//
//        //stop
        rtPower.setPower(0);
        ltPower.setPower(0);
        rtPower.setPower(0);
        ltPower.setPower(0);
        sleep(1000);

        hLeft.setPosition(0);
        sleep(500);


    }








}
