import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Dungeons{
	public static void main(String[] args) {
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
		System.out.print("\n" + playerBack);

		 //race stat modifications
		modRaceStat(playerRace, statArray);

		//skills and stuff
		int[] skillsArray = new int[18];
		getSkills(playerClass, playerRace, playerBack, skillsArray);

		//assign the stat modifiers
		int[] statsMod = new int[6];
		getStatsMod(statsMod, statArray);

		//assigns the skill modifiers
		int[] skillModArray = new int[18];
		getSkillMods(statsMod, skillsArray, skillModArray);

		//using this to check if program is working, comment out when done
		System.out.println("Your stats are\n--------------\nSTR: " + statArray[0] + "\nDEX: " + statArray[1] +
			"\nCON: " + statArray[2] + "\nINT: " + statArray[3] + "\nWIS: " + statArray[4] + "\nCHA: " + statArray[5]);

		//comment out when done, skill mod output
		for (int i =0; i < skillModArray.length; i++) {
			System.out.println(skillModArray[i]);
		}

	}

		//saved stuff for later 
		/*
		//class stuff
		String dndClassChoice = "";
	
		switch(dndClass){
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
			*/
	

	
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

		System.out.print("Type the number of the class you want to choose: \n1. Barbarian" +
			"\n2. Bard\n3. Cleric\n4. Druid\n5. Fighter\n6. Monk\n7. Paladin\n8. Ranger" + 
			"\n9. Rogue\n10. Sorcerer\n11. Warlock\n12. Wizard\n");
		Scanner input = new Scanner(System.in);
		int dndClass = input.nextInt();

		return dndClass;	
	}

	public static String getRace(){

		//race selection
		System.out.print("Type the number of the race you want to choose: \n1. Dwarf" +
			"\n2. Elf\n3. Halfling\n4. Human\n5. Dragonborn\n6. Gnome\n7. Half-Elf" +
			"\n8. Half-Orc\n9. Tiefling\n");
		Scanner input = new Scanner(System.in);
		int dndRace = input.nextInt();



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

		System.out.print("Type the number of the background you want to choose: \n1. Acolyte" +
			"\n2. Charlatan\n3. Criminal\n4. Entertainer\n5. Guild Artisan\n6. Hermit\n7. Noble" +
			"\n8. Outlander\n9. Sage\n10. Soldier\n11. Urchin\n");	
		Scanner input = new Scanner(System.in);
		int dndBack = input.nextInt();

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
					
					System.out.print("Please enter: STR, DEX, CON, INT, WIS, CHA\n");

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
			break;
		}

		Scanner input = new Scanner(System.in);
		int[] tempSkills = new int [18];
		String[] tempNameSkills = new String[] {"Acrobatics","Animal Handling","Arcana","Athletics","Deception","History","Insight","Intimidation","Investigation","Medicine","Nature","Perception","Performance","Persuasion","Religion","Sleight of Hand","Stealth","Survival"};

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

			for (int i = 0; i < numSkills; i++){

				System.out.print("Select which skills you'd like to be proficient in:\n");
				for (int j = 0; j < tempSkills.length; j++){
					if(tempSkills[j] == 1 && skillsArray[j] == 0){//skill is available for the class and not already given
						System.out.print(j +". "+ tempNameSkills[j] + "\n");
					}
				}
				
				int skillChoice = input.nextInt();

				if (tempSkills[skillChoice] == 1 && skillsArray[skillChoice] == 0) {
					skillsArray[skillChoice] = 1;//assign the skill
				} else i--;	
			}
			
		case 2: 
			for (int i = 0; i < tempSkills.length; i++) {
				tempSkills[i] = 1;
			}
			numSkills = 3;

			for (int i = 0; i < numSkills; i++){

				System.out.print("Select which skills you'd like to be proficient in:\n");
				for (int j = 0; j < tempSkills.length; j++){
					if(tempSkills[j] == 1 && skillsArray[j] == 0){//skill is available for the class and not already given
						System.out.print(j +". "+ tempNameSkills[j] + "\n");
					}
				}
				
				int skillChoice = input.nextInt();

				if (tempSkills[skillChoice] == 1 && skillsArray[skillChoice] == 0) {
					skillsArray[skillChoice] = 1;//assign the skill
				} else i--;	
			}

		case 3:
			tempSkills[5] = 1;
			tempSkills[6] = 1;
			tempSkills[9] = 1;
			tempSkills[13] = 1;
			tempSkills[14] = 1;
			numSkills = 2;

			for (int i = 0; i < numSkills; i++){

				System.out.print("Select which skills you'd like to be proficient in:\n");
				for (int j = 0; j < tempSkills.length; j++){
					if(tempSkills[j] == 1 && skillsArray[j] == 0){//skill is available for the class and not already given
						System.out.print(j +". "+ tempNameSkills[j] + "\n");
					}
				}
				
				int skillChoice = input.nextInt();

				if (tempSkills[skillChoice] == 1 && skillsArray[skillChoice] == 0) {
					skillsArray[skillChoice] = 1;//assign the skill
				} else i--;	
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
	}
}
