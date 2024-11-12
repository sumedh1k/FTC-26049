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
        robot.driveStraight(.5f, 5, telemetry, this);
        robot.stopDriving();
        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);
    }
}