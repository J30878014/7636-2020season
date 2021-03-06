/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Powercell.Shooter;


public class FastShoot extends CommandBase {
  private Shooter m_Shooter;
  private int i;

  /**
   * Creates a new Shoot.
   */
  public FastShoot(Shooter shooter) {
   m_Shooter = shooter;
    addRequirements(m_Shooter);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    i=0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Shooter.flywheelspinup(12000);
    m_Shooter.fastconveyor();
    i++;
    SmartDashboard.putString("FlyWheelstatus", "flywheelSpin");
    m_Shooter.widein();
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Shooter.flywheelstop();
    m_Shooter.conveyorstop();
    SmartDashboard.putString("FlyWheelstatus", "flywheelStop");
    i=0;
    m_Shooter.widestop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
