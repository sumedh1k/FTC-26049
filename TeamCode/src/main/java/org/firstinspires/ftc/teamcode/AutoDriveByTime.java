package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Auto Drive By Time", group="MyHardware")
public class AutoDriveByTime extends LinearOpMode {
    MyHardware robot = new MyHardware();
    ElapsedTime runTime = new ElapsedTime();
    @Override
    public void runOpMode(){
        robot.init(hardwareMap);
        telemetry.addData("Status", "Ready to run");
        telemetry.update();
        waitForStart();
        robot.Lift(-.5f, 2f, telemetry, this);
        /*
        robot.driveStraight(.25f, .6f, telemetry, this);
        robot.stopDriving();
        robot.SidewaysLeft(.25f, .5f, telemetry, this);
        robot.stopDriving();
        robot.IntakeArmDown(this, telemetry);
        robot.Lift(.5f, 2f, telemetry, this);
        robot.stopLift();
        robot.Lift(-.5f, 1f, telemetry, this);
        robot.stopLift();
        robot.SpecimenClawOpen();*/
        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);
    }
}