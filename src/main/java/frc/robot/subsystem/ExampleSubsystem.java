package frc.robot.subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.unmanaged.Unmanaged;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ExampleSubsystem extends SubsystemBase {
    TalonFX mainMotor = new TalonFX(13);
    TalonFX followMotor = new TalonFX(23);
    
    public ExampleSubsystem() {
        mainMotor.configFactoryDefault();
        followMotor.configFactoryDefault();

        mainMotor.setInverted(false);
        followMotor.setInverted(true);

        followMotor.follow(mainMotor);
    }

    public void setOutput(double output) {
        mainMotor.set(ControlMode.PercentOutput, output);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Main Output", mainMotor.getMotorOutputPercent());
        SmartDashboard.putNumber("Follow Output", followMotor.getMotorOutputPercent());
    }

    @Override
    public void simulationPeriodic() {
        Unmanaged.feedEnable(20);
    }
    
}
