package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Autonomous
public class MyHardware {
    DcMotor RFMotor = null; // Right Front motor
    DcMotor LFMotor = null; // Left Front motor
    DcMotor RBMotor = null; // Right Back motor
    DcMotor LBMotor = null; // Left Back motor
    HardwareMap hwMap = null;
    ElapsedTime period = new ElapsedTime();
    public MyHardware(){}
    public void init(HardwareMap ahwMap){
        hwMap = ahwMap;
        LBMotor = hwMap.get(DcMotor.class, "motor");
        RBMotor = hwMap.get(DcMotor.class,   "motor1");
        RFMotor = hwMap.get(DcMotor.class, "motor2");
        LFMotor = hwMap.get(DcMotor.class, "motor3");
        RFMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        RBMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        this.stopDriving();
        LFMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RFMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LBMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RBMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void stopDriving(){
        LFMotor.setPower(0);
        RFMotor.setPower(0);
        LBMotor.setPower(0);
        RBMotor.setPower(0);
    }
    public void driveStraight(double power, float seconds, Telemetry telemetry, LinearOpMode opMode){
        LFMotor.setPower(-power);
        RFMotor.setPower(power);
        LBMotor.setPower(power);
        RBMotor.setPower(-power);
        ElapsedTime runTime = new ElapsedTime();
        runTime.reset();
        while(opMode.opModeIsActive() && (runTime.seconds() < seconds)){
            telemetry.addData("Path", "driveStraight: %2.5f S Elapsed", runTime.seconds());
            telemetry.update();
        }
    }
    public void SidewaysLeft(double power, float seconds, Telemetry telemetry, LinearOpMode opMode){
        LFMotor.setPower(-power);
        RFMotor.setPower(-power);
        LBMotor.setPower(-power);
        RBMotor.setPower(-power);
        ElapsedTime runTime = new ElapsedTime();
        runTime.reset();
        while(opMode.opModeIsActive() && (runTime.seconds() < seconds)){
            telemetry.addData("Path", "SidewaysLeft: %2.5f S Elapsed", runTime.seconds());
            telemetry.update();
        }
    }
    public void SidewaysRight(double power, float seconds, Telemetry telemetry, LinearOpMode opMode){
        LFMotor.setPower(power);
        RFMotor.setPower(power);
        LBMotor.setPower(power);
        RBMotor.setPower(power);
        ElapsedTime runTime = new ElapsedTime();
        runTime.reset();
        while(opMode.opModeIsActive() && (runTime.seconds() < seconds)){
            telemetry.addData("Path", "SidewaysRight: %2.5f S Elapsed", runTime.seconds());
            telemetry.update();
        }
    }
    public void RotationRight(double power, float seconds, Telemetry telemetry, LinearOpMode opMode){
        LFMotor.setPower(power);
        RFMotor.setPower(-power);
        LBMotor.setPower(power);
        RBMotor.setPower(-power);
        ElapsedTime runTime = new ElapsedTime();
        runTime.reset();
        while(opMode.opModeIsActive() && (runTime.seconds() < seconds)){
            telemetry.addData("Path", "RotationRight: %2.5f S Elapsed", runTime.seconds());
            telemetry.update();
        }
    }
    public void RotationLeft(double power, float seconds, Telemetry telemetry, LinearOpMode opMode){
        LFMotor.setPower(-power);
        RFMotor.setPower(power);
        LBMotor.setPower(-power);
        RBMotor.setPower(power);
        ElapsedTime runTime = new ElapsedTime();
        runTime.reset();
        while(opMode.opModeIsActive() && (runTime.seconds() < seconds)){
            telemetry.addData("Path", "RotationRight: %2.5f S Elapsed", runTime.seconds());
            telemetry.update();
        }
    }
}
/*
Sideways(To the left)
all negative
Sideways(To the right)
all positive
rotation(right)
positive, negative, positive, negative
rotation(left)
negative, positive, negative, positive
 */
