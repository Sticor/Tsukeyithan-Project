
package Tsukeyithan.Player.Vuurkhen;

import java.util.Random;

import org.lwjgl.input.Mouse;

import Tsukeyithan.Manager.TKHEntityManager;
import Tsukeyithan.Packet.Packet136AddSkillEffect;
import Tsukeyithan.Packet.Packet137RemoveSkillEffect;
import Tsukeyithan.Skill.TKHSkill;
import Tsukeyithan.Skill.TKHSkillEffect;

import net.minecraft.client.Minecraft;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityClientPlayerMP;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.Material;
import net.minecraft.src.NetClientHandler;
import net.minecraft.src.Session;
import net.minecraft.src.World;

public class TKHCMPEntityVuurkhenMale extends EntityClientPlayerMP {

	public TKHCMPEntityVuurkhenMale(Minecraft par1Minecraft, World par2World,
			Session par3Session, NetClientHandler par4NetClientHandler) {
		super(par1Minecraft, par2World, par3Session, par4NetClientHandler);
		entityType = "Vuurkhen";
		TKHEntityManager.entitySexe = "Male";
		texture = "/Tsukeyithan/Skin/VuurkhenMale.png";
		skinUrl = (new StringBuilder())
				.append("http://walkixx.com/Minecraft/Tsukeyithan/Skin/")
				.append(entityType).append("/").append(par3Session.username)
				.append(".png").toString();
        speedOnGround = 0.1F*0.9F;
        speedInAir = 0.02F*0.9F;
        addSkillEffect(new TKHSkillEffect(TKHSkill.isVuurkhen.skillID, -1, 0));
		addSkillEffect(new TKHSkillEffect(TKHSkill.speedLava.skillID, -1, 0));
		addSkillEffect(new TKHSkillEffect(TKHSkill.sprintLava.skillID, -1, 0));
		addSkillEffect(new TKHSkillEffect(TKHSkill.dropMeat.skillID, -1, 0));
		addSkillEffect(new TKHSkillEffect(TKHSkill.doubleDamage.skillID, -1, 0));
		addSkillEffect(new TKHSkillEffect(TKHSkill.reductExplDmg.skillID, -1, 0));
		this.isImmuneToFire = true;
		TKHEntityManager.maxPowerCD = 600;
	}
	
	public void onUpdate() {
		super.onUpdate();

		if (this.mc.gameSettings.keyBindFPower.isPressed() && TKHEntityManager.powerCD == TKHEntityManager.maxPowerCD) {
			this.mc.getSendQueue().addToSendQueue(new Packet136AddSkillEffect(this.entityId, TKHSkill.carbonization.skillID, -1));
			TKHEntityManager.powerCD = 1;
		}
        
        if (this.mc.gameSettings.keyBindSPower.isPressed()) {
			if (isSkillActive(TKHSkill.walkLava))
				this.mc.getSendQueue().addToSendQueue(new Packet137RemoveSkillEffect(this.entityId, TKHSkill.walkLava.skillID, -1));
			else
				this.mc.getSendQueue().addToSendQueue(new Packet137RemoveSkillEffect(this.entityId, TKHSkill.walkLava.skillID, -1));
		}
	}

	public int getMaxHealth() {
		return 40;
	}
}