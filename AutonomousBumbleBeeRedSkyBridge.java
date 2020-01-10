package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Autonomous Red Bumble Bee Sky Bridge", group="Pushbot")
//@Disabled
public class AutonomousBumbleBeeRedSkyBridge extends LinearOpMode {

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
    public void runOpMode() {

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



        hRight.setPosition(0);
        hLeft.setPosition(1);



        // Tell the driver that initialization is complete.
        telemetry.addData("Status", "Initialized");
        telemetry.update();



        waitForStart();


        //Go left
        ltPower.setPower(-.25);
        lbPower.setPower(.25);
        rtPower.setPower(.25);
        rbPower.setPower(-.25);
        sleep(2700);


        //stop
        rtPower.setPower(0);
        ltPower.setPower(0);
        rbPower.setPower(0);
        lbPower.setPower(0);
        sleep(1000);



        //Move Forward
        //rbPower.setPower(-.5);
        //lbPower.setPower(-.5);
        rtPower.setPower(.5);
        ltPower.setPower(.5);
        sleep(2000);



    }








}
