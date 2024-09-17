package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class drive extends SubsystemBase {
    private TalonSRX leftFrontMotor;
    private TalonSRX leftTopMotor;
    private TalonSRX leftBackMotor;
    private TalonSRX rightFrontMotor;
    private TalonSRX rightTopMotor;
    private TalonSRX rightBackMotor;
    private static drive driveInstance;

    private drive() {
        leftFrontMotor = new TalonSRX(Constants.driveConstants.leftFrontID);
        leftTopMotor = new TalonSRX(Constants.driveConstants.leftTopID);
        leftTopMotor.setInverted(true);
        leftBackMotor = new TalonSRX(Constants.driveConstants.leftBackID);
        rightFrontMotor = new TalonSRX(Constants.driveConstants.rightFrontID);
        rightFrontMotor.setInverted(true);
        rightTopMotor = new TalonSRX(Constants.driveConstants.rightTopID);
        rightBackMotor = new TalonSRX(Constants.driveConstants.rightBackID);
        rightBackMotor.setInverted(true);
    }

    public static drive getInstance() {
        if (driveInstance == null) {
            driveInstance = new drive();
        }
        return driveInstance;
    }

    public void leftMovement(double speed) {
        leftFrontMotor.set(TalonSRXControlMode.PercentOutput, speed);
        leftTopMotor.set(TalonSRXControlMode.PercentOutput, speed);
        leftBackMotor.set(TalonSRXControlMode.PercentOutput, speed);
    }

    public void rightMovement(double speed) {
        rightFrontMotor.set(TalonSRXControlMode.PercentOutput, speed);
        rightTopMotor.set(TalonSRXControlMode.PercentOutput, speed);
        rightBackMotor.set(TalonSRXControlMode.PercentOutput, speed);
    }

    
}
