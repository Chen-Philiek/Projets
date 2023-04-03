package com.isep.hpah.core;

import lombok.*;
import java.util.List;
import java.util.Scanner;
@Getter @Setter
public class Wizard extends Character{
     private Pet pet;
     private Wand wand;
     private House house;
     private List<Potion> potions;
     private List<Spell> knownSpells;
     private int health;
     private int max_health;
     private boolean ChapterSevenIsOk = false;



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

        System.out.println("Choisissez l'action voulu\uD83E\uDD14:\n1. Lancer un sort\n2. Utiliser une potion\n3. M'enfuir");
        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextInt();
        switch (action) {
            case 1 -> this.castSpell(ennemies);
            case 2 -> this.usePotion();
            case 3 -> this.flee(ennemies);
            default -> System.out.println("Action invalide");
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


        }if (i==4 && this.getHealth()>0) {
            System.out.println("Vous avez réussi à fuir !");
            System.out.println("Vous êtes autorisés à aller dans le chapitre suivant !");
            ChapterFive();
        }
        if (i ==5 && this.getHealth()>0 ){
            System.out.println("Vous avez obtenus les feux d'artifices !");
            System.out.println("Maintenant que la fête commence !");
            System.out.println("Vous êtes autorisés à aller dans le chapitre suivant !");
            ChapterSix();
        }
        if (i==6 && this.getHealth() >0 ){
            System.out.println("Vous pouvez décider de vous allier aux Mangemorts si vous êtes de serpentard !");
            System.out.println("Vous êtes autorisés à aller dans le chapitre suivant !");
            ChapterSeven();
        }
        if (i ==7 && this.getHealth()>0){
            System.out.println("Vous avez vaincu Voldemort et Bellatrix, Vous êtes maintenant diplômé !");
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
            System.out.println("Vous n'avez aucune potion dans l'inventaire !❌");
            return;
        }
        System.out.println("Choisissez la potion à utiliser \uD83E\uDD14:");
        for (int i = 0; i < potions.size(); i++) {
            System.out.println((i + 1) + ". " + potions.get(i).getName() + " (" + potions.get(i).getHealAmount() + " heal)");
        }
        Scanner scanner = new Scanner(System.in);
        int potionIndex = scanner.nextInt()-1;
        Potion potion = potions.get(potionIndex);
        int heal1 = (int) potion.getHealAmount();
        if (this.getHouse() == House.HUFFLEPUFF){
            heal1 += 20;
        }
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
        System.out.println("Choisissez le sort à jeter :");
        for (int b = 0; b < knownSpells.size(); b++) {
            System.out.println((b + 1) + ". " + knownSpells.get(b).getName() + " (" + knownSpells.get(b).getDamage() + " damage)");

        }
        dodge(ennemies);

    }

//Lancement de combat
    public void fight(AbstractEnemy ennemies){
        boolean Status = true; // Quand le combat n'est pas terminé
        while (Status) {
            if (ennemies.getHealth()>0 && this.getHealth()>0) {
                Status = this.wizardturn(ennemies);
                ennemies.enemyturn(this);
                if (this.wand.getCore() == Core.PHOENIX_FEATHER && ChapterSevenIsOk){
                    System.out.println("""
                            Voldemort et Vous se tiennent face à face, chacun avec leur baguette magique en main, prêts à s'affronter dans un duel sans merci. Voldemort et vous êtes concentrés, prêts à utiliser votre magie pour gagner l'avantage sur l'autre.

                            Soudain, vous levez tous les deux vos baguette magique et prononcent leur sortilège en même temps. Mais quelque chose d'étrange se produit : au moment où les deux sorts se rencontrent, une explosion se produit, aveuglant les deux sorciers.

                            Quand vous réouvrez les yeux, vous vous rendez compte qu'un effet imprévisible s'est produit : Vos baguettes magiques ont été interconnectées par la magie des sorts que vous avez lancés en même temps, créant une réaction inattendue qui a stoppé le combat.

                            Vous deux sorciers se regarde, interloqués. Vous vous rendez compte que vos baguettes magiques sont désormais liées l'une à l'autre, et qu'ils ne peuvent plus l'utiliser l'une contre l'autre.

                            Après un moment de réflexion, Vous et Voldemort décident de mettre fin à leur rivalité. Vous vous éloignez, chacun de leur côté, sachant que la magie leur réserve encore bien des surprises imprévisibles.""");

                    System.out.println("Vous êtes maintenant diplômé !");
                    System.exit(0);

                }else{
                    Status = this.wizardturn(ennemies);
                    ennemies.voldturn(this);


                }

            }else{return;}

        }
    }
//Le wizard prend du damage
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

// Régénération de points de vies
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
    // Passer au chapitre suivant
    private boolean gotonextChapter(int i) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voulez vous passer au chapitre suivant ? : \n1.Oui \uD83D\uDE00 \n2.Non je veux arreter le jeu \uD83D\uDE14");
        int numberSpell = scanner.nextInt();
        switch (numberSpell) {
            case 1 -> {
                boolean clearchap = true;// The chapter is cleaned
                while (clearchap) {
                    clearchap = this.passChapter(i);}
                return true;}
            case 2 -> {
                return false;}
        }
        return gotonextChapter(i);
    }
    //Apprentissage de nouveau sort
    private void learnSpell() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisissez un nouveau sort \uD83E\uDD14: \n1.Accio (Recommandé si vous n'êtes pas de Gryffindor)\n2.GryffindorSword \n3.Expecto Patronum (efficace face aux détraqueurs !)");
        int numberSpell = scanner.nextInt();
        Spell chosenSpell = null;
        switch (numberSpell) {
            case 1 -> chosenSpell = Spell.Accio;
            case 2 -> chosenSpell = Spell.GryffindorSword;
            case 3 -> chosenSpell = Spell.ExpectoPatronum;
            default -> learnSpell();
        }
        assert chosenSpell != null;
        System.out.println("Vous avez choisis : " + chosenSpell.getName());
        this.getKnownSpells().add(chosenSpell);
    }
    private void learnSpell1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisissez un nouveau sort \uD83E\uDD14: \n 1.Sectumsempra");
        int numberSpell = scanner.nextInt();
        Spell chosenSpell = null;
        if (numberSpell == 1) {
            chosenSpell = Spell.Sectumsempra;
        } else {
            learnSpell();
        }
        System.out.println("Vous avez choisis : " + chosenSpell.getName());
        this.getKnownSpells().add(chosenSpell);
    }
    //Probabilité de rater son sort
    private void dodge(AbstractEnemy ennemies) {
        Scanner scanner = new Scanner(System.in);
        int spellIndex = scanner.nextInt() - 1;
        Spell spell = knownSpells.get(spellIndex);

        int damage = spell.getDamage();
        int dogdeChance = (int) (Math.random() * 101);
        int valeurRan = 100;
        if(this.getHouse() == House.RAVENCLAW){dogdeChance = (int) (Math.random()*91);}
        if (dogdeChance < 0.65 * valeurRan) {
            System.out.println("Vous lancez " + spell.getName() + " et infligez " + damage + " de dégâts au " + ennemies.getName() + "\n");
            ennemies.takeDamage(this, damage);
            if (ennemies.getHealth() < 0) {this.drop(ennemies);}
        } if (dogdeChance > 0.65*valeurRan) {System.out.println("Vous avez raté votre sort");

        }

    }
private void dodgeset(){
    setDogdeChance(dogdeChance + 10);
    System.out.println(" Votre chance à augmenter de :" + dogdeChance);
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
                spell.setDamage(getDamage() + 5);

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
            this.upStats();
            this.gotonextChapter(i);
        }else{
            System.out.println("Vous avez perdu !");
        }
    }
    public void ChapterFour() {
        System.out.println("<" + longTrait + "Chapitre 4" + longTrait + ">\n");
        System.out.println("The Goblet of Fire\n\n");
        System.out.println("""
                Par malheur, vous avez remporté le Tournoi des Trois Sorciers... et le droit de mourir. Vous êtes
                dans un cimetière, où se trouvent aussi Voldemort et Peter Pettigrew. Votre seule chance de fuite est
                de vous rapprocher du Portkey pour l’attirer à vous (Accio !). Ne vous inquiétez pas, vous reverrez
                Voldemort.
                """);
        Wait.wait(2000);
        System.out.println("Deux boss apparaissent !\nIl semblerait que ce soit Voldemort et Peter Pettygrow en même temps!");
        System.out.println("Trouvez Portkey et utilisez Accio pour pouvoir vous enfuir !");
        Wait.wait(2000);
        System.out.println("Vous avez trouvé Portkey");

        this.fight(Enemy.creatPorkey());
        System.out.println("Cliquez sur le 2 pour continuer :\n2. Continuer");
        Scanner scanner = new Scanner(System.in);
        int spellIndex = scanner.nextInt() - 1;
        Spell spell = knownSpells.get(spellIndex);

        int i =4;
        if (this.getHealth()>0 && spell.getName().equals("Accio")) {
            this.gotonextChapter(i);

        }if(this.getHealth()>0){
            System.out.println("Vous avez utilisé le mauvais sort!\n");
            System.out.println("Vous devez maintenant affronter les deux boss ensemble");
            this.fight(Boss.createDoubleBoss());
            if (this.getHealth()>0){this.gotonextChapter(i);}
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
        this.fight(Boss.createDolores());
        int i = 5;
        if (this.getHealth()>0){
            this.upStats();
            this.gotonextChapter(i);
        }
        else{
            System.out.println("Vous avez perdu !");
        }
    }
    public void ChapterSix(){
        System.out.println("<"+longTrait +"Chapitre 6" + longTrait +">\n");
        System.out.println("The Half-Blood Prince\n");
        System.out.println("""
                Les Mangemorts attaquent Poudlard. Êtes-vous prêts à vous défendre ? Vous devez les attaquer
                de face (Sectumsempra). Si vous êtes de Serpentard, vous pouvez décider de rejoindre les rangs des
                Mangemorts.
                """);
        learnSpell1();
        Wait.wait(2000);
        System.out.println("Un ennemi apparaît !\n");
        Wait.wait(2000);

        this.fight(Boss.createMangemorts());
        System.out.println("CLiquez sur 4 pour voir la suite : \n4. Continuer");
        Scanner scanner = new Scanner(System.in);
        int spellIndex = scanner.nextInt() - 1;
        Spell spell = knownSpells.get(spellIndex);
        int i =6;
        if (this.getHealth()>0 && spell.getName().equals("Sectumsempra")) {
            System.out.println("Vous vous êtes associés aux Mangemorts");
            System.out.println("Vous êtes maintenant du côté de Voldemort ! Par conséquent vous ne pouvez pas être diplômé !");
            System.exit(0);
        }else if(this.getHealth()>0){
            System.out.println("Attention le combat commence");
            this.fight(Boss.createMangemorts());
            this.fight(Boss.createMangemorts());
            this.fight(Boss.createMangemorts());
            if (this.getHealth()>0){this.gotonextChapter(i);}
        }
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
        System.out.println("Voldemort et Bellatrix apparaîssent !\n");
        Wait.wait(2000);
        ChapterSevenIsOk = true;
        this.fight(Boss.createVoledemort());
        this.fight(Boss.createBella());
        if (this.getHealth()>0){
            System.out.println("Vous êtes maintenant diplômé !");
        }
        else{
            System.out.println("Malheuresement vous êtes mort à la dernière année..");
        }

    }

}







