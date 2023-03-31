// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.subsystem.ExampleSubsystem;

public class RobotContainer {
  ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  
  public RobotContainer() {
    m_exampleSubsystem.setDefaultCommand(new RunCommand(()-> m_exampleSubsystem.setOutput(0.3), m_exampleSubsystem));
    configureBindings();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
