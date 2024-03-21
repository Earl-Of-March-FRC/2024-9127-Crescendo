// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.CommandGroups.DrivetrainAutos.Sensor;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.CommandGroups.MainAutos.AutoLog;
import frc.robot.Commands.Drivetrain.TurnPIDCmd;
import frc.robot.Subsystems.DrivetrainSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ChassisTurnVariable extends SequentialCommandGroup {
  /** Creates a new ChassisTurnVariable. */
  public ChassisTurnVariable(
    DrivetrainSubsystem driveSub,
    DoubleSupplier turnAngle
  ) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new AutoLog("Turning" + turnAngle + "degrees"),
      new TurnPIDCmd(driveSub,
        () -> driveSub.getGyroAngle() + turnAngle.getAsDouble(),
        () -> 1,
        () -> false,
        () -> driveSub.getTurnController().atSetpoint()
      )
    );
  }
}