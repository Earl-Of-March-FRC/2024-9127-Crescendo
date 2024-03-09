// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimberConstants;

public class ClimberSubsystem extends SubsystemBase {
  /** Creates a new ClimberSubsystem. */
  private final WPI_TalonSRX climber = new WPI_TalonSRX(ClimberConstants.climberID);

  public ClimberSubsystem() {
    //leftClimber.setInverted(true);
   // leftClimber.setIdleMode(IdleMode.kBrake);
    climber.setNeutralMode(NeutralMode.Brake);
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void setMotor(double speed){
    climber.set(speed);
  }
}
