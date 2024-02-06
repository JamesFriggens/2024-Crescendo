package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import com.revrobotics.SparkAbsoluteEncoder;
import com.revrobotics.CANSparkBase.IdleMode;

import edu.wpi.first.wpilibj.DutyCycleEncoder;

public class ArmSubsystem extends SubsystemBase{


    private CANSparkMax leftArmMotor;
    private CANSparkMax rightArmMotor;
    private DutyCycleEncoder throughBoreEncoder;
    private DoubleSolenoid extendSolenoid;


    public ArmSubsystem(){

        leftArmMotor = new CANSparkMax (28, MotorType.kBrushless);
        rightArmMotor = new CANSparkMax (29, MotorType.kBrushless);

        leftArmMotor.setIdleMode(IdleMode.kBrake);
        rightArmMotor.setIdleMode(IdleMode.kBrake);
        leftArmMotor.follow(rightArmMotor);
        // throughBoreEncoder = new SparkAbsoluteEncoder(leftArmMotor, )
        //create CANSparkMax IDs
        extendSolenoid = new DoubleSolenoid (PneumaticsModuleType.CTREPCM, 0, 1);
        throughBoreEncoder = new DutyCycleEncoder(0);

        leftArmMotor.follow(rightArmMotor);
        

    } 

    
    
    public void rotateArmUp(){
        
        leftArmMotor.set(1);
        // rotateMotor2.set(1);
        
    }
    public void rotateArmDown(){
        leftArmMotor.set(-1);
        // rotateMotor2.set(-1);
    }
    public void StopArm(){
        leftArmMotor.stopMotor();
        // rotateMotor2.set(0);
    }

    public void rotateArm(double value){
        leftArmMotor.set(value);
    }


    public void extendArm(){

        extendSolenoid.set(Value.kForward);
    }

    public void retractArm(){

        extendSolenoid.set(Value.kReverse);
    }    

    public void toggleArm(){
         
        extendSolenoid.toggle();
    }

    public double getArmPosition(){
        return throughBoreEncoder.getAbsolutePosition();
    }


} 







