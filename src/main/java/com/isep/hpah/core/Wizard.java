package com.isep.hpah.core;

import lombok.*;
import java.util.List;
import java.util.Scanner;

public class Wizard extends Character{
    @Getter @Setter private Pet pet;
    @Getter @Setter private Wand wand;
    @Getter @Setter  private House house;
    @Getter @Setter private List<Potion> potions;
    @Getter @Setter private List<Spell> knownSpells;
    @Getter @Setter private int health;
    @Getter @Setter private int max_health;


    String longTrait = "-".repeat(50);

    public static int randomHealth(){
        System.out.println("Vous avez : " + health() + " points de vies");
        return health();
    }
    private static int health() {
        return 500;
    }

    private static int max_health(){
        return 500;
    }

    public static int MaxHealth(){
        System.out.println("Vous avez un au maximum " + max_health() + " au début de la partie");
        return max_health();
    }

    public void start(AbstractEnemy ennemies) {

        System.out.println("Choose your action\uD83E\uDD14:\n1. Cast spell\n2. Use potion\n3. Flee");

        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextInt();
        switch (action) {
            case 1 -> this.castSpell(ennemies);
            case 2 -> this.usePotion();
            case 3 -> this.flee(ennemies);
            default -> System.out.println("Invalid action");
        }
    }

    public boolean passChapter(int i){

        if (i == 1 && this.getHealth()>0){
            System.out.println("Vous avez vaincu les ennemies !");
            System.out.println("Vous êtes autorisés à aller dans le chapitre suivant !");
            ChapterTwo();

        }if (i ==2 && this.getHealth()>0){
            System.out.println("Vous avez réussi à détruire le journal !");
            System.out.println("Vous êtes autorisés à aller dans le chapitre suivant !");
            ChapterThree();
        }if (i ==3 && this.getHealth()>0){
            System.out.println("Les détraqueurs s'enfuient !");
            System.out.println("Vous êtes autorisés à aller dans le chapitre suivant !");
            ChapterFour();
            System.out.println("Trouvez Portkey et utilisez Accio pour pouvoir vous enfuir !");
        }if (i==4 && this.getHealth()>0) {
            System.out.println("Vous avez réussi à fuir !");
            System.out.println("Vous êtes autorisés à aller dans le chapitre suivant !");
        }

        else{
            return false;}
        return false;
    }


    public boolean wizardturn(AbstractEnemy ennemies){
        if (ennemies.getHealth() > 0 && this.getHealth()>0) {
            this.start(ennemies);
            return true;
        }if (this.getHealth()<0){
            System.out.println("Le jeu est perdu !\uD83D\uDE14");

        }
        return true;
    }
    //Potion part
    public void usePotion() {
        List<Potion> potions = this.getPotions();
        if (potions.isEmpty()) {
            System.out.println("You don't have any potion!❌");
            return;
        }
        System.out.println("Choose the potion to use \uD83E\uDD14:");
        for (int i = 0; i < potions.size(); i++) {
            System.out.println((i + 1) + ". " + potions.get(i).getName() + " (" + potions.get(i).getHealAmount() + " heal)");
        }
        Scanner scanner = new Scanner(System.in);
        int potionIndex = scanner.nextInt()-1;
        Potion potion = potions.get(potionIndex);
        int heal1 = (int) potion.getHealAmount();
        System.out.println("Vous utilisez " + potion.getName() + " et vous régénérez " + heal1 + " de points de vie\n");
        this.Healing(heal1);
        potions.remove(potion);

    }
    // Flee part
    public void flee(AbstractEnemy ennemies) {
        int fleeChance = (int) (Math.random() * 101); // Tirage aléatoire d'un nombre entre 0 et 100
        if (fleeChance > 50) {
            System.out.println(this.getName() + " réussit à fuir !\uD83C\uDF89");
            System.exit(0);
        } else {
            System.out.println(this.getName() + " ne parvient pas à fuir et doit combattre " + ennemies.getName() + " !❌");
        }
    }
    // Drop Potion part
    public void drop(AbstractEnemy ennemies) {
        int valeur = 100;
        int dropPotion = (int) (Math.random() * 101); // Tirage aléatoire d'un nombre entre 0 et 100
        if ((dropPotion> 0.3 * valeur) && (dropPotion < 0.6 * valeur)) {
            this.getPotions().add(Potion.PotiondeDittany);
            System.out.println("Vous avez obtenue une nouvelle potion !\uD83C\uDF89" );

        }if ((dropPotion> 0.1 * valeur) &&dropPotion < 0.3*valeur){
            this.getPotions().add(Potion.BriseLame);
            System.out.println("Vous avez obtenue une nouvelle potion !\uD83C\uDF89" );

        }if (dropPotion < 0.1 * valeur){
            this.getPotions().add(Potion.BaumedeFierabras);
            System.out.println("Vous avez obtenue une nouvelle potion !\uD83C\uDF89" );
        }
        if (dropPotion > 0.6 * valeur) {
            System.out.println("L'ennemie n'a rien laissé sur lui \uD83D\uDE14");
        }

    }

    public void castSpell(AbstractEnemy ennemies) {
        List<Spell> knownSpells = this.getKnownSpells();
        if (knownSpells.isEmpty()) {
            System.out.println("You don't know any spell!");
            return;
        }
        System.out.println("Choose the spell to cast:");
        for (int i = 0; i < knownSpells.size(); i++) {
            System.out.println((i + 1) + ". " + knownSpells.get(i).getName() + " (" + knownSpells.get(i).getDamage() + " damage)");

        }
        dodge(ennemies);

    }

    public void fight(AbstractEnemy ennemies){
        boolean Status = true; // Quand le combat n'est pas terminé
        while (Status) {
            if (ennemies.getHealth()>0 && this.getHealth()>0) {
                Status = this.wizardturn(ennemies);
                ennemies.enemyturn(this);
            }else{return;}

        }
    }

    public void takeDamage(int damage1) {

        this.setHealth(getHealth() - damage1);

        System.out.println(this.getName() + " prend " + damage1 + " points de dégâts !");
        System.out.println("-----------------------------------------------");
        System.out.println("|      Il vous reste :" + getHealth() + " points de vie !     |");
        System.out.println("-----------------------------------------------");

        if (getHealth() <= 0) {
            this.setAlive(false);
            System.out.println(this.getName() + " est mort !");

        }
    }

    public void Healing(int heal1) {
        this.setHealth(getHealth() + heal1);
        if (getHealth() > 500) {
            this.setHealth(getHealth() -(getHealth()- max_health()));
            System.out.println("Vous avez " +  getHealth() + " points de vies");
        } else {
            System.out.println(this.getName() + " régénère " + heal1 + " points de vies !");
            System.out.println("------------------------------------------------------");
            System.out.println("|      Vous avez maintenant :" + getHealth() + " points de vie !     |");
            System.out.println("------------------------------------------------------");
        }
    }
    private boolean gotonextChapter(int i) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voulez vous passer au chapitre suivant ? : \n1.Oui \uD83D\uDE00 \n2.Non je veux arreter le jeu \uD83D\uDE14");
        int numberSpell = scanner.nextInt();
        switch (numberSpell) {
            case 1 -> {
                boolean clearchap = true;// The chapter is cleaned
                while (clearchap) {
                    clearchap = this.passChapter(i);

                }
                return true;
            }
            case 2 -> {
                return false;
            }
        }
        return gotonextChapter(i);
    }
    private void learnSpell() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a new spell or other \uD83E\uDD14: \n1.Accio (Recommandé si vous n'êtes pas de Gryffindor)\n2.GryffindorSword \n3.Expecto Patronum (efficace face aux détraqueurs !)");
        int numberSpell = scanner.nextInt();
        Spell chosenSpell = null;
        switch (numberSpell) {
            case 1 -> chosenSpell = Spell.Accio;
            case 2 -> chosenSpell = Spell.GryffindorSword;
            case 3 -> chosenSpell = Spell.ExpectoPatronum;
            default -> learnSpell();
        }
        System.out.println("You chose the : " + chosenSpell.getName());
        this.getKnownSpells().add(chosenSpell);
    }
    private void dodge(AbstractEnemy ennemies) {
        Scanner scanner = new Scanner(System.in);
        int spellIndex = scanner.nextInt() - 1;
        Spell spell = knownSpells.get(spellIndex);
        int damage = spell.getDamage();
        int dogdeChance = (int) (Math.random() * 101);
        int valeurRan = 100;
        if (dogdeChance < 0.65 * valeurRan) {
            System.out.println("Vous lancez " + spell.getName() + " et infligez " + damage + " de dégâts au " + ennemies.getName() + "\n");
            ennemies.takeDamage(damage);
            if (ennemies.getHealth() < 0) {
                this.drop(ennemies);
            }

        } if (dogdeChance > 0.65*valeurRan) {
            System.out.println("Vous avez raté votre sort");

        }
    }
private void dodgeset(){
    setDogdeChance(dogdeChance + 10);
    System.out.println(" dodge chance :" + dogdeChance);
    // Appel de la méthode spellStat pour mettre à jour les dégâts supplémentaires

}
    private void upStats() {
        System.out.println("Choose a stat to levelup \uD83E\uDD14: \n1.Points de vies \n2.Attaque \n3.Precision");
        Scanner scanner = new Scanner(System.in);
        int numberStat = scanner.nextInt();
        switch (numberStat) {
            case 1 -> this.setHealth(getHealth() + 40);
            case 2 -> {
                System.out.println("Choose a spell to update:");
                for (int i = 0; i < knownSpells.size(); i++) {
                    System.out.println((i + 1) + ". " + knownSpells.get(i).getName());
                }
                int spellIndex = scanner.nextInt() -1;
                Spell spell = knownSpells.get(spellIndex);
                spell.spellStat(5);
            }
            case 3 -> dodgeset();
            default -> upStats();
        }

    }


    public void ChapterOne(){
        System.out.println("<"+longTrait +"Chapitre 1" + longTrait +">\n");
        System.out.println("The Philosopher's Stone\n");
        System.out.println("Vous arrivez devant le donjon et vous sentez une odeur de durian sur vos mains et vous décidez d'aller au toilette...\n");
        Wait.wait(2000);
        System.out.println("Un ennemi apparaît ! Pour le terasser, il vous faut utiliser le sort Wingardium Leviosa !\n");
        Wait.wait(2000);
        this.fight(Enemy.createTroll());
        int i = 1;
        if (this.getHealth()>0) {
            this.upStats();
            this.gotonextChapter(i);
        }else{
             System.out.println("Vous avez perdu !");
        }



    }
    public void ChapterTwo(){
        System.out.println("<"+longTrait +"Chapitre 2" + longTrait +">\n");
        System.out.println("The Chamber of Secrets\n");
        System.out.println("""
                Vous êtes face au terrible basilic. Si vous êtes de Griffondor, vous pouvez faire appel à l’épée
                légendaire de Godric Gryffindor pour le terrasser. Sinon, il faudra lui arracher un de ses crocs et
                l’utiliser pour détruire le journal de Tom Jedusor.
                """);
        Wait.wait(2000);
        this.learnSpell();
        System.out.println("Un ennemi apparaît !\n");
        Wait.wait(2000);
        this.fight(Enemy.createTroll());
        System.out.println("Un Boss apparaît !");
        Wait.wait(2000);
        this.fight(Boss.createBasilik());
        int i=2;
        if (this.getHealth()>0) {

            //on ajoute ici le code pour demander quel attribut monté en pts
            this.gotonextChapter(i);
        }else{
            System.out.println("Vous avez perdu !");
        }


    }

    public void ChapterThree(){
        System.out.println("<"+longTrait +"Chapitre 3" + longTrait +">\n");
        System.out.println("The Prisonner of Azkaban\n");
        System.out.println("""
                Les Détraqueurs sont en liberté. Ils errent dans les rues, les campagnes. Heureusement, vous avez
                entendu parler d’un sort pour les mettre en fuite... Expect... Expecta... Ah oui, Expectro Patronum.
                Votre objecif est d’apprendre le sort, puis de l’utiliser pour vaincre les Détraqueurs.
                """);
        Wait.wait(2000);
        this.learnSpell();
        System.out.println("Un ennemi apparaît !\n");
        Wait.wait(2000);
        this.fight(Boss.createBasilik());
        System.out.println("Un Boss apparaît !");
        Wait.wait(2000);
        this.fight(Boss.createDetraqueurs());
        int i =3;
        if (this.getHealth()>0) {
            this.gotonextChapter(i);
        }else{
            System.out.println("Vous avez perdu !");
        }
    }
    public void ChapterFour(){
        System.out.println("<"+longTrait +"Chapitre 4" + longTrait +">\n");
        System.out.println("The Goblet of Fire\n\n");
        System.out.println("""
                Par malheur, vous avez remporté le Tournoi des Trois Sorciers... et le droit de mourir. Vous êtes
                dans un cimetière, où se trouvent aussi Voldemort et Peter Pettigrew. Votre seule chance de fuite est
                de vous rapprocher du Portkey pour l’attirer à vous (Accio !). Ne vous inquiétez pas, vous reverrez
                Voldemort.
                """);
        Wait.wait(2000);
        System.out.println("Deux boss apparaissent !\n Il semblerait que ce soit Voledemort et Peter Pettygrow en même temps!");
        Wait.wait(2000);

        this.fight(Boss.createDoubleBoss());
        int i =4;
        if (this.getHealth()>0) {
            this.gotonextChapter(i);
        }else{
            System.out.println("Vous avez perdu !");
        }
    }

    public void ChapterFive(){
        System.out.println("<"+longTrait +"Chapitre 5" + longTrait +">\n");
        System.out.println("The Order of the Phenix\n");
        System.out.println("""
                C’est l’heure du BUSE (Brevet Universel de Sorcellerie Élémentaire) ! Dolores Ombrage veille sur
                le grain. Votre objectif est de la distraire le temps que les feux d’artifice soient prêts à être utilisés.

                """);
        Wait.wait(2000);
        System.out.println("Un ennemi apparaît !\n");
        Wait.wait(2000);
    }
    public void ChapterSix(){
        System.out.println("<"+longTrait +"Chapitre 6" + longTrait +">\n");
        System.out.println("The Half-Blood Prince\n");
        System.out.println("""
                Les Mangemorts attaquent Poudlard. Êtes-vous prêts à vous défendre ? Vous devez les attaquer
                de face (Sectumsempra). Si vous êtes de Serpentard, vous pouvez décider de rejoindre les rangs des
                Mangemorts.
                """);
        Wait.wait(2000);
        System.out.println("Un ennemi apparaît !\n");
        Wait.wait(2000);
    }
    public void ChapterSeven(){
        System.out.println("<"+longTrait +"Chapitre 7" + longTrait +">\n");
        System.out.println("The Deathly Hallows\n");
        System.out.println("""
                Trêve de tergiversations, il faut attaquer le problème à la source. Vous êtes face à Voldemort et a
                Bellatrix Lestrange. Faites attention, ils peuvent vous tuer d’un coup avec Avada Kedavra si vous
                n’êtes pas prêts.
                """);
        Wait.wait(2000);
        System.out.println("Un ennemi apparaît !\n");
        Wait.wait(2000);
    }

}







