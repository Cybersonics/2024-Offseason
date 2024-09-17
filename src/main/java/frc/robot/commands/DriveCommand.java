package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.drive;

public class DriveCommand extends Command{
  private drive drive;
  private DoubleSupplier leftstick;
  private DoubleSupplier rightstick;
  
  
    public DriveCommand(drive drivesystem,DoubleSupplier leftvalue,DoubleSupplier rightvalue){
        drive = drivesystem;
        leftstick = leftvalue;
        rightstick = rightvalue;
        addRequirements(drive);
    }
    @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftSpeed = leftstick.getAsDouble();
    if (leftSpeed >0 || leftSpeed <0) 
    {
        drive.leftMovement(-leftSpeed);
    }
   double rightSpeed = rightstick.getAsDouble();
    if (rightSpeed >0 || rightSpeed <0) 
    {
        drive.rightMovement(-rightSpeed);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

