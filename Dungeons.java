import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Dungeons{
	public static void main(String[] args) throws Exception{
			Scanner input = new Scanner(System.in);
			System.out.print("Enter a character name: ");
			String characterName = input.nextLine();
			
			//class selection
			int playerClass = getClassD();
			System.out.print(playerClass);
			
			//race and subrace selection
			String playerRace = getRace();
			System.out.print("\n" + playerRace + "\n");

			 //stat rolls and selection
			int[] statArray = new int[6];
			getStatRolls(statArray);

			 //background selection
			int playerBack = getBackground();

			 //race stat modifications
			modRaceStat(playerRace, statArray);

			//skills and stuff
			int[] skillsArray = new int[19];
			getSkills(playerClass, playerRace, playerBack, skillsArray);

			//assign the stat modifiers
			int[] statsMod = new int[6];
			getStatsMod(statsMod, statArray);

			//assigns the skill modifiers
			int[] skillModArray = new int[19];
			getSkillMods(statsMod, skillsArray, skillModArray);

			//assigns the saving throws array
			int[] savingThrowArray = new int[6];
			getSavingThrowMods(playerClass, statsMod, savingThrowArray);

			charSheet(characterName, playerClass, playerRace, statArray, playerBack, skillsArray, statsMod, skillModArray, savingThrowArray);
	}
	public static int statRolls(){
		Random randomGenerator=new Random();
		int[] statRollArray = new int[4];
		int finalStat = 0;
		for(int j = 0; j < 4; j++){
			int statRolls = randomGenerator.nextInt(5 + 1) + 1;
			statRollArray[j] = statRolls;
		}
		java.util.Arrays.sort(statRollArray);
		finalStat = statRollArray[1] + statRollArray[2] + statRollArray[3];

		return finalStat; 
	} 

	public static int getClassD(){
		Scanner input = new Scanner(System.in);
		int dndClass = 100;
		String s = "";
		while (dndClass < 1 || dndClass > 12) {
			boolean valid = false;//initial setting of the flag
			while(!valid) {//while the input isnt an integer
				System.out.print("Type the number of the class you want to choose: \n1. Barbarian" +
					"\n2. Bard\n3. Cleric\n4. Druid\n5. Fighter\n6. Monk\n7. Paladin\n8. Ranger" + 
					"\n9. Rogue\n10. Sorcerer\n11. Warlock\n12. Wizard\n");
					s = input.nextLine();//get output into a string
				valid = isInt(s);//call isInt method returning whether it's valid
			}
			dndClass = Integer.parseInt(s);//parse the integer which then gets checked whether it's in the range specified. If not, it runs both loops again.
		}
		return dndClass;	
	}

	public static String getRace(){
		Scanner input = new Scanner(System.in);
		//race selection
		int dndRace = 0;
		while (dndRace < 1 || dndRace > 9) {
			System.out.print("Type the number of the race you want to choose: \n1. Dwarf" +
				"\n2. Elf\n3. Halfling\n4. Human\n5. Dragonborn\n6. Gnome\n7. Half-Elf" +
				"\n8. Half-Orc\n9. Tiefling\n");
			dndRace = input.nextInt();
		}


		String dndRaceChoice = "";
		int dndSubraceChoice = 0;

		//subrace selection system
		switch(dndRace){
		case 1: dndRaceChoice = "Dwarf";
			System.out.println("Please choose a subrace.\n1. Hill Dwarf (+2 CON) " + 
				" (+1 WIS)\n2. Mountain Dwarf (+2 STR) (+2 CON)");
			dndSubraceChoice = input.nextInt();
			switch(dndSubraceChoice){
			case 1: dndRaceChoice = "Hill Dwarf";
				break;	
			case 2: dndRaceChoice = "Mountain Dwarf";
				break;	
			}
			break;
		case 2: dndRaceChoice = "Elf";
			System.out.println("Please choose a subrace.\n1. High Elf (+2 DEX) " + 
				" (+1 INT)\n2. Wood Elf (+2 DEX) (+1 WIS)");
			dndSubraceChoice = input.nextInt();
			switch(dndSubraceChoice){
			case 1: dndRaceChoice = "High Elf";
				break;	
			case 2: dndRaceChoice = "Wood Elf";
				break;	
			}
			break;
		case 3: dndRaceChoice = "Halfling";
			System.out.println("Please choose a subrace.\n1. Lightfoot Halfling (+2 DEX) " + 
				" (+1 CHA)\n2. Stout Halfling (+2 DEX) (+1 CON)");
			dndSubraceChoice = input.nextInt();
			switch(dndSubraceChoice){
			case 1: dndRaceChoice = "Lightfoot Halfling";
				break;	
			case 2: dndRaceChoice = "Stout Halfling";
				break;	
			}
			break;
		case 4: dndRaceChoice = "Human";
			System.out.println("Human (+1 to all stats)");

			break;
		case 5: dndRaceChoice = "Dragonborn";
			System.out.println("Dragonborn (+2 STR) (+1 CHA)");
			
			break;
		case 6: dndRaceChoice = "Gnome";
			System.out.println("Please choose a subrace.\n1. Forest Gnome (+1 DEX) " + 
				" (+2 INT)\n2. Rock Gnome (+1 CON) (+2 INT)");
			dndSubraceChoice = input.nextInt();
			switch(dndSubraceChoice){
			case 1: dndRaceChoice = "Forest Gnome";
				break;	
			case 2: dndRaceChoice = "Rock Gnome";
				break;	
			}
			break;
		case 7: dndRaceChoice = "Half-Elf";
			System.out.println("Half-Elf (+2 CHA)");
			
			break;
		case 8: dndRaceChoice = "Half-Orc";
			System.out.println("Half-Orc (+2 DEX) (+1 CON)");
			
			break;
		case 9: dndRaceChoice = "Tiefling";
			System.out.println("Tiefling (+2 CHA) (+1 INT)");
			
			break;
		}

		return dndRaceChoice;
	}

	public static void getStatRolls(int statArray[]){

		//stat rolls system
		Random randomGenerator=new Random();
		int[] finalRollsArray = new int[6];
		int finalStat = 0;

		System.out.print("Your stat rolls are: ");
		for(int i =0; i < 6; i++){
			finalRollsArray[i] = statRolls();
			System.out.print(finalRollsArray[i] + " ");
		}

		//stat assignment
		System.out.println("\nStat options: STR, DEX, CON, INT, WIS, CHA");
		System.out.println("Type an option to assign to the stat rolled.");
		

		for (int i = 0; i < finalRollsArray.length; i++){ 

			System.out.println("Select stat for: " + finalRollsArray[i]);
			Scanner input = new Scanner(System.in);
			String statAllo = input.nextLine();
			String statAlloLow = statAllo.toLowerCase();
			if (statAlloLow.equals("str") || statAlloLow.equals("dex") || statAlloLow.equals("wis") ||
				statAlloLow.equals("con") || statAlloLow.equals("int") || statAlloLow.equals("cha")){
				switch(statAlloLow){
				case "str":
					if (statArray[0] == 0){
						statArray[0] = finalRollsArray[i];
					} else {
						System.out.println("You have already assigned the Strength stat!");
						i--;
					}
					break;

				case "dex":
					if (statArray[1] == 0){
						statArray[1] = finalRollsArray[i];
					} else {
						System.out.println("You have already assigned the Dexterity stat!");
						i--;
					}
					break;
				case "con":
					if (statArray[2] == 0){
						statArray[2] = finalRollsArray[i];
					} else {
						System.out.println("You have already assigned the Constitution stat!");
						i--;
					}
					break;
				case "int":
					if (statArray[3] == 0){
						statArray[3] = finalRollsArray[i];
					} else {
						System.out.println("You have already assigned the Intelligence stat!");
						i--;
					}
					break;
				case "wis":
					if (statArray[4] == 0){
						statArray[4] = finalRollsArray[i];
					} else {
						System.out.println("You have already assigned the Wisdom stat!");
						i--;
					}
					break;
				case "cha":
					if (statArray[5] == 0){
						statArray[5] = finalRollsArray[i];
					} else {
						System.out.println("You have already assigned the Charisma stat!");
						i--;
					}
					break;
				}
			} else {
				System.out.print("Please enter: STR, DEX, CON, INT, WIS, CHA\n");
				i--;
			}

		}

	}

	public static int getBackground(){
		Scanner input = new Scanner(System.in);
		int dndBack = 100;
		String s  = "";
		while(dndBack < 1 || dndBack > 11) {//we would set the desired range here
			boolean valid = false;//initial setting of the flag
			while(!valid) {//while the input isnt an integer
				System.out.print("Type the number of the background you want to choose: \n1. Acolyte" +
					"\n2. Charlatan\n3. Criminal\n4. Entertainer\n5. Guild Artisan\n6. Hermit\n7. Noble" +
					"\n8. Outlander\n9. Sage\n10. Soldier\n11. Urchin\n");	
				s = input.nextLine();//get output into a string
				valid = isInt(s);//call isInt method returning whether it's valid
			}
			dndBack = Integer.parseInt(s);//parse the integer which then gets checked whether it's in the range specified. If not, it runs both loops again.
		}
		return dndBack;
	}

	public static void modRaceStat(String tempRace, int statArray[]){

		Scanner input = new Scanner(System.in);

		switch(tempRace){
		case "Hill Dwarf":
			statArray[2] += 2;
			statArray[4] += 1;
			break;
		case "Mountain Dwarf":
			statArray[0] += 2;
			statArray[2] += 2;
			break;
		case "High Elf":
			statArray[1] += 2;
			statArray[3] += 1;
			break;
		case "Wood Elf":
			statArray[1] += 2;
			statArray[4] += 1;
			break;
		case "Lightfoot Halfling":
			statArray[1] += 2;
			statArray[5] += 1;
			break;
		case "Stout Halfling":
			statArray[1] += 2;
			statArray[2] += 1;
			break;
		case "Human":
			statArray[0] += 1;
			statArray[1] += 1;
			statArray[2] += 1;
			statArray[3] += 1;
			statArray[4] += 1;
			statArray[5] += 1;
			break;
		case "Dragonborn":
			statArray[0] += 2;
			statArray[5] += 1;
			break;
		case "Forest Gnome":
			statArray[1] += 1;
			statArray[3] += 2;
			break;
		case "Rock Gnome":
			statArray[2] += 1;
			statArray[3] += 2;
			break;
		case "Half-Elf":
			statArray[5] += 2;
			
			boolean strBoo, dexBoo, conBoo, intBoo, wisBoo;
			strBoo = dexBoo = conBoo = intBoo = wisBoo = false;

			for(int i = 0; i < 2; i++){
				System.out.print("Which two stats would like to increase by 1\nOptions: STR, DEX, CON, INT, WIS\n");
				String statChoice = input.nextLine();
				statChoice = statChoice.toLowerCase();
				
				if (statChoice.equals("str") || statChoice.equals("dex") || statChoice.equals("wis") ||
					statChoice.equals("con") || statChoice.equals("int")){
						switch(statChoice){
							case "str":
								if(strBoo == false){
									statArray[0] += 1;
								}
								strBoo = true;
								break;
							case "dex":
								if(dexBoo == false){
									statArray[1] += 1;
								}
								dexBoo = true;
								break;
							case "con":
								if(conBoo == false){
									statArray[2] += 1;
								}
								conBoo = true;
								break;
							case "int":
								if(intBoo == false){
									statArray[3] += 1;
								}
								intBoo = true;
								break;
							case "wis":
								if(wisBoo == false){
									statArray[4] += 1;
								}
								wisBoo = true;
								break;
						}
				} else
					
					System.out.print("Please enter: STR, DEX, CON, INT, WIS\n");

			}

			break;
		case "Half-Orc":
			statArray[0] += 2;
			statArray[2] += 1;
			break;
		case "Tiefling":
			statArray[3] += 1;
			statArray[5] += 2;
			break;

		}
	}

	public static void getSkills(int tempClass, String race, int tempBack, int skillsArray[]){

		if(race.equals("Half-Orc")){

			skillsArray[7] = 1;
		}

		switch(tempBack){
		case 1: skillsArray[6] = 1;
			skillsArray[14] = 1;
			break;
		case 2:skillsArray[4] = 1;
			skillsArray[15] = 1;
			break;
		case 3: skillsArray[4] = 1;
			skillsArray[16] = 1;
			skillsArray[18]=1;//automatic proficiency with theives' tools
			break;
		case 4: skillsArray[0] = 1;
			skillsArray[12] = 1;
			break;
		case 5: skillsArray[6] = 1;
			skillsArray[13] = 1;
			break;
		case 6: skillsArray[9] = 1;
			skillsArray[14] = 1;
			break;
		case 7: skillsArray[5] = 1;
			skillsArray[13] = 1;
			break;
		case 8: skillsArray[3] = 1;
			skillsArray[17] = 1;
			break;
		case 9: skillsArray[2] = 1;
			skillsArray[5] = 1;
			break;
		case 10: skillsArray[3] = 1;
			skillsArray[7] = 1;
			break;
		case 11: skillsArray[15] = 1;
			skillsArray[16] = 1;
			skillsArray[18] = 1;//automatic proficiency with theives' tools
			break;
		}

		Scanner input = new Scanner(System.in);
		int[] tempSkills = new int [19];
		String[] tempNameSkills = new String[] {"Acrobatics","Animal Handling","Arcana","Athletics","Deception","History","Insight","Intimidation","Investigation","Medicine","Nature","Perception","Performance","Persuasion","Religion","Sleight of Hand","Stealth","Survival","Thieves Tools"};

		int numSkills = 0;

		switch(tempClass){
		case 1: 
			tempSkills[1] = 1;
			tempSkills[3] = 1;
			tempSkills[7] = 1;
			tempSkills[10] = 1;
			tempSkills[11] = 1;
			tempSkills[17] = 1;
			numSkills = 2;
			break;
			
		case 2: 
			for (int i = 0; i < tempSkills.length; i++) {
				tempSkills[i] = 1;
			}
			numSkills = 3;
			break;

		case 3:
			tempSkills[5] = 1;
			tempSkills[6] = 1;
			tempSkills[9] = 1;
			tempSkills[13] = 1;
			tempSkills[14] = 1;
			numSkills = 2;
			skillsArray[18] = 1;
			break;
				
		case 4: 
			tempSkills[2] = 1;
			tempSkills[3] = 1;
			tempSkills[6] = 1;
			tempSkills[9] = 1;
			tempSkills[10] = 1;
			tempSkills[11] = 1;
			tempSkills[14] = 1;
			tempSkills[17] = 1;
			numSkills = 2;
			break;
		
		case 5: 
			tempSkills[0] = 1;
			tempSkills[1] = 1;
			tempSkills[3] = 1;
			tempSkills[5] = 1;
			tempSkills[6] = 1;
			tempSkills[7] = 1;
			tempSkills[11] = 1;
			numSkills = 2;
			break;
		
		case 6:
			tempSkills[0] = 1;
			tempSkills[3] = 1;
			tempSkills[5] = 1;
			tempSkills[6] = 1;
			tempSkills[14] = 1;
			tempSkills[16] = 1;
			numSkills = 2;
			break;
				
		case 7:
			tempSkills[3] = 1;
			tempSkills[6] = 1;
			tempSkills[9] = 1;
			tempSkills[13] = 1;
			tempSkills[14] = 1;
			numSkills = 2;
			break;
				
		case 8:
			tempSkills[1] = 1;
			tempSkills[3] = 1;
			tempSkills[6] = 1;
			tempSkills[8] = 1;
			tempSkills[10] = 1;
			tempSkills[11] = 1;
			tempSkills[16] = 1;
			tempSkills[17] = 1;
			numSkills = 3;
			break;
				
		case 9:
			tempSkills[0] = 1;
			tempSkills[3] = 1;
			tempSkills[4] = 1;
			tempSkills[6] = 1;
			tempSkills[7] = 1;
			tempSkills[8] = 1;
			tempSkills[11] = 1;
			tempSkills[12] = 1;
			tempSkills[13] = 1;
			tempSkills[15] = 1;
			tempSkills[16] = 1;
			numSkills = 4;
			skillsArray[18] = 1;//automatic proficiency with theives' tools
			break;
				
		case 10:
			tempSkills[2] = 1;
			tempSkills[4] = 1;
			tempSkills[6] = 1;
			tempSkills[7] = 1;
			tempSkills[13] = 1;
			tempSkills[14] = 1;
			numSkills = 2;
			break;
				
		case 11:
			tempSkills[2] = 1;
			tempSkills[4] = 1;
			tempSkills[5] = 1;
			tempSkills[7] = 1;
			tempSkills[8] = 1;
			tempSkills[10] = 1;
			tempSkills[14] = 1;
			numSkills = 2;
			break;
				
		case 12:
			tempSkills[2] = 1;
			tempSkills[5] = 1;
			tempSkills[6] = 1;
			tempSkills[8] = 1;
			tempSkills[9] = 1;
			tempSkills[14] = 1;
			numSkills =2;
			break;
		}
		for (int i = 0; i < numSkills; i++){//assign appropriate skills
			int skillChoice = 100;//set far outside the range
			String s = "";
				while(skillChoice > 18) {//we would set the desired range here
					boolean valid = false;//initial setting of the flag
					while(!valid) {//while the input isnt an integer
						System.out.print("Select which skills you'd like to be proficient in:\n");
						for (int j = 0; j < tempSkills.length-1; j++){
							if(tempSkills[j] == 1 && skillsArray[j] == 0){//skill is available for the class and not already given
								System.out.print(j +". "+ tempNameSkills[j] + "\n");
							}
						}
						s = input.nextLine();//get output into a string
						valid = isInt(s);//call isInt method returning whether it's valid
					}
					skillChoice = Integer.parseInt(s);//parse the integer which then gets checked whether it's in the range specified. If not, it runs both loops again.
					if (tempSkills[skillChoice] == 1 && skillsArray[skillChoice] == 0) {
						skillsArray[skillChoice] = 1;//assign the skill
					} else i--;	
				}
			}

		if (tempClass == 9) {//Rogue Expertise
			for (int k = 0; k < 2 ; k++) {
				int expertiseChoice = 100;
				String s = "";
				while(expertiseChoice > 18) {
					boolean valid = false;
					while(!valid) {
						System.out.println("Select which skills the Rogue will have expertise in (double proficiency)");
						for (int l = 0; l < skillsArray.length; l++) {
							if (skillsArray[l] == 1)
								System.out.print(l + ". " + tempNameSkills[l] + "\n");
						}
						s = input.nextLine();
						valid = isInt(s);
					}
					expertiseChoice = Integer.parseInt(s);
					if (skillsArray[expertiseChoice] == 1)
						skillsArray[expertiseChoice] = 2;
					else k--;
				}
		}
	}
}
	public static void getStatsMod(int statsMod[], int statArray[]) { //assigns the stat modifier
		for (int i = 0; i < statArray.length; i++) {
			statsMod[i] = (statArray[i] / 2) - 5;
		}
	}

	public static void getSkillMods(int statsMod[], int skillsArray[], int skillModArray[]) {
		final int PROFICIENCY = 2;//Proficiency bonus
		//assigning each skill mod based on stat modifier and proficiency
		skillModArray[0] = statsMod[1] + (PROFICIENCY * skillsArray[0]);
		skillModArray[1] = statsMod[4] + (PROFICIENCY * skillsArray[1]);
		skillModArray[2] = statsMod[3] + (PROFICIENCY * skillsArray[2]);
		skillModArray[3] = statsMod[0] + (PROFICIENCY * skillsArray[3]);
		skillModArray[4] = statsMod[5] + (PROFICIENCY * skillsArray[4]);
		skillModArray[5] = statsMod[3] + (PROFICIENCY * skillsArray[5]);
		skillModArray[6] = statsMod[4] + (PROFICIENCY * skillsArray[6]);
		skillModArray[7] = statsMod[5] + (PROFICIENCY * skillsArray[7]);
		skillModArray[8] = statsMod[3] + (PROFICIENCY * skillsArray[8]);
		skillModArray[9] = statsMod[4] + (PROFICIENCY * skillsArray[9]);
		skillModArray[10] = statsMod[3] + (PROFICIENCY * skillsArray[10]);
		skillModArray[11] = statsMod[4] + (PROFICIENCY * skillsArray[11]);
		skillModArray[12] = statsMod[5] + (PROFICIENCY * skillsArray[12]);
		skillModArray[13] = statsMod[5] + (PROFICIENCY * skillsArray[13]);
		skillModArray[14] = statsMod[3] + (PROFICIENCY * skillsArray[14]);
		skillModArray[15] = statsMod[1] + (PROFICIENCY * skillsArray[15]);
		skillModArray[16] = statsMod[1] + (PROFICIENCY * skillsArray[16]);
		skillModArray[17] = statsMod[4] + (PROFICIENCY * skillsArray[17]);
		skillModArray[18] = statsMod[1] + (PROFICIENCY * skillsArray[18]);
	}

	public static void getSavingThrowMods(int playerClass, int statsMod[], int savingThrowArray[]) {
		final int PROFICIENCY = 2;
		for (int i = 0; i < savingThrowArray.length; i++) {
			savingThrowArray[i] = statsMod[i];
		}
		switch(playerClass) {
		case 1:
			savingThrowArray[0] += PROFICIENCY;
			savingThrowArray[2] += PROFICIENCY;
			break;
		case 2:
			savingThrowArray[1] += PROFICIENCY;
			savingThrowArray[5] += PROFICIENCY;
			break;
		case 3:
			savingThrowArray[4] += PROFICIENCY;
			savingThrowArray[5] += PROFICIENCY;
			break;
		case 4:
			savingThrowArray[3] += PROFICIENCY;
			savingThrowArray[4] += PROFICIENCY;
			break;
		case 5:
			savingThrowArray[0] += PROFICIENCY;
			savingThrowArray[2] += PROFICIENCY;
			break;
		case 6:
			savingThrowArray[0] += PROFICIENCY;
			savingThrowArray[1] += PROFICIENCY;
			break;
		case 7:
			savingThrowArray[4] += PROFICIENCY;
			savingThrowArray[5] += PROFICIENCY;
			break;
		case 8:
			savingThrowArray[0] += PROFICIENCY;
			savingThrowArray[1] += PROFICIENCY;
			break;
		case 9:
			savingThrowArray[1] += PROFICIENCY;
			savingThrowArray[3] += PROFICIENCY;
			break;
		case 10:
			savingThrowArray[4] += PROFICIENCY;
			savingThrowArray[5] += PROFICIENCY;
			break;
		case 11:
			savingThrowArray[3] += PROFICIENCY;
			savingThrowArray[4] += PROFICIENCY;
			break;
		}
	}
	public static void charSheet (String playerName, int playerClass, String playerRace, int statArray[], int playerBack, int skillsArray[], int statsMod[], int skillModArray[], int savingThrowArray[]) throws Exception{
		String fileName = playerName + ".txt";
		java.io.File outFile = new java.io.File(fileName);
		java.io.PrintWriter output = new java.io.PrintWriter(outFile);
		String dndClassChoice = "";
		switch(playerClass){
		case 1: dndClassChoice = "Barbarian";
			break;
		case 2: dndClassChoice = "Bard";
			break;
		case 3: dndClassChoice = "Cleric";
			break;
		case 4: dndClassChoice = "Druid";
			break;
		case 5: dndClassChoice = "Fighter";
			break;
		case 6: dndClassChoice = "Monk";
			break;
		case 7: dndClassChoice = "Paladin";
			break;
		case 8: dndClassChoice = "Ranger";
			break;
		case 9: dndClassChoice = "Rogue";
			break;
		case 10: dndClassChoice = "Sorc";
			break;
		case 11: dndClassChoice = "Warlock";
			break;
		case 12: dndClassChoice = "Wizard";
			break;
		}
		int hp = 0;
		switch(playerClass) {
		case 1:
			hp = 12 + statsMod[2];
			break;
		case 5: case 7: case 8:
			hp = 10 + statsMod[2];
			break;
		case 10: case 12:
			hp = 6 + statsMod[2];
			break;
		default:
			hp = 8 + statsMod[2];
			break;
		}
		int speed = 0;
		switch(playerRace) {
		case "Hill Dwarf": case "Mountain Dwarf": case "Lightfoot Halfling": case "Stout Halfling": case "Forest Gnome": case "Rock Gnome":
			speed = 25;
			break;
		case "Wood Elf":
			speed = 35;
			break;
		default: 
			speed = 30;
	}
	int ac = 10 + statsMod[1];//assign the AC stat based on dex mod
	if (playerClass == 1)//Take care of the barbarian unarmored defense
		ac += statsMod[2];
	if (playerClass == 6)//Take care of the monk unarmored defense
		ac += statsMod[4];
	String background = "";
	switch(playerBack) {
	case 1:
		background = "Acolyte";
		break;
	case 2:
		background = "Charlatan";
		break;
	case 3:
		background = "Criminal";
		break;
	case 4:
		background = "Entertainer";
		break;
	case 5:
		background = "Guild Artisan";
		break;
	case 6:
		background = "Hermit";
		break;
	case 7:
		background = "Noble";
		break;
	case 8:
		background = "Outlander";
		break;
	case 9:
		background = "Sage";
		break;
	case 10:
		background = "Soldier";
		break;
	case 11:
		background = "Urchin";
		break;	
	}
	String[] profArray = new String[19];
	for (int i = 0; i < profArray.length; i++) {
		if (skillsArray[i] == 1)
			profArray[i] = "x";
		else if (skillsArray[i] == 2)
			profArray[i] = "X";
		else
			profArray[i] = " ";
	}
		
		output.println("      ______ _                         _____                      _                ");
   		output.println("      | ___ \\ |                       |  _  |                    (_)              ");
   		output.println("      | |_/ / | __ _ _   _  ___ _ __  | | | |_   _____ _ ____   ___  _____      __ ");
   		output.println("      |  __/| |/ _` | | | |/ _ \\ '__| | | | \\ \\ / / _ \\ '__\\ \\ / / |/ _ \\ \\ /\\ / / ");
   		output.println("      | |   | | (_| | |_| |  __/ |    \\ \\_/ /\\ V /  __/ |   \\ V /| |  __/\\ V  V /  ");
   		output.println("      \\_|   |_|\\__,_|\\__, |\\___|_|     \\___/  \\_/ \\___|_|    \\_/ |_|\\___| \\_/\\_/   ");
   		output.println("                      __/ |                                                        ");
   		output.println("                     |___/                                                         ");
   		output.println("==============================================================================================================");
   		output.println("IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
   		output.println("==============================================================================================================");

		output.print(String.format("Name: %-21s Race: %-20s Class: %-15s Level: 1\n", playerName, playerRace, dndClassChoice));
		output.print(String.format("Background: %-15s Armor Class: %-13d Hit Points: %-10d Speed: %-8d Initiative: %+3d", background, ac, hp, speed, statsMod[1]));
		
		output.println("\n--------------------------------------------------------------------------------------------------------------");
		output.println("                                                   S T A T S                                               ");
		output.println("--------------------------------------------------------------------------------------------------------------");

		output.print("                   STR   DEX   CON   INT   WIS   CHA");
		output.print(String.format("\nAbility Scores: %5d %5d %5d %5d %5d %5d", statArray[0], statArray[1], statArray[2], statArray[3], statArray[4], statArray[5]));
		output.print(String.format("\nAbility Modifier:%+4d %+5d %+5d %+5d %+5d %+5d", statsMod[0], statsMod[1], statsMod[2], statsMod[3], statsMod[4], statsMod[5]));
		output.print(String.format("\nSaving Throws:   %+4d %+5d %+5d %+5d %+5d %+5d", savingThrowArray[0], savingThrowArray[1], savingThrowArray[2], savingThrowArray[3], savingThrowArray[4], savingThrowArray[5]));
		
		output.println("\n--------------------------------------------------------------------------------------------------------------");
		output.println("                                                   S K I L L S                                             ");		
		output.println("--------------------------------------------------------------------------------------------------------------");

		output.print(String.format("[%1s] Acrobatics %+-8d [%1s] Animal Handling %+-4d [%1s] Arcana %+-3d", profArray[0],skillModArray[0], profArray[1], skillModArray[1], profArray[2], skillModArray[2]));
		output.print(String.format("\n[%1s] Athletics %+-9d [%1s] Deception %+-10d [%1s] History %+-3d", profArray[3],skillModArray[3], profArray[4], skillModArray[4], profArray[5], skillModArray[5]));
		output.print(String.format("\n[%1s] Insight %+-11d [%1s] Intimidation %+-7d [%1s] Investigation %+-3d", profArray[6],skillModArray[6], profArray[7], skillModArray[7], profArray[8], skillModArray[8]));
		output.print(String.format("\n[%1s] Medicine %+-10d [%1s] Nature %+-13d [%1s] Perception %+-3d", profArray[9],skillModArray[9], profArray[10], skillModArray[10], profArray[11], skillModArray[11]));
		output.print(String.format("\n[%1s] Performance %+-7d [%1s] Persuasion %+-9d [%1s] Religion %+-3d", profArray[12],skillModArray[12], profArray[13], skillModArray[13], profArray[14], skillModArray[14]));
		output.print(String.format("\n[%1s] Sleight of Hand %+-3d [%1s] Stealth %+-12d [%1s] Survival %+-3d", profArray[15],skillModArray[15], profArray[16], skillModArray[16], profArray[17], skillModArray[17]));
		if (playerClass == 9 || playerBack == 3 || playerBack == 11)
			output.print(String.format("\n[%1s] Thieves' Tools %+-3d", profArray[18], skillModArray[18]));
		System.out.println("Your character sheet was created.");
		output.close();
	}

	private static boolean isInt(String s) {
		try {//anything in the try block may cause an error
			Integer.parseInt(s);
		}
		catch (NumberFormatException nfe) {//if an error occurs (the string s isn't parseable), the catch block is run
			return false;//returns false keeping the inner loop running
		}
		return true;//The string was parseable meaning that the string was an integer.
	}
}
