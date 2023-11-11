// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

/** An example command that uses an example subsystem. */
public class IntakeCube extends CommandBase {
  private final Intake intake;
  private Timer timer;
  private double lengthOfIntake;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public IntakeCube(Intake intake, double lengthOfIntake) {
    this.intake = intake;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(this.intake);
    timer = new Timer();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // TODO: set game piece int to 0 for cube
    intake.setGamePieceType(0);
    // TODO: use appropriate function from Intake.java class (intake.set__Power)
    intake.setCubeIntakePower();
    //this timer is to test for how long the game piece has been intaking.
    timer.reset();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
<<<<<<< Updated upstream
=======
    if(timer > lengthOfIntake){

    }
>>>>>>> Stashed changes
  }
  
  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // TODO: reduce to a low holding power (use function from Intake.java class)
    intake.setCubeHoldPower();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(timer.get() > lengthOfIntake){
      if(lengthOfIntake == 0) {
        return false;
      } else {
          return true;
      }
    }else {
      return false;
    }
  }
}
