package com.fogodev.firebird;

import java.util.Set;

/**
 * Criado por ericson em 20/10/16.
 *
 * https://github.com/fogodev
 */
public class FlappyBird implements Jogo
{
    private String spritesFile = "resources/flappy.png";

    private Scenario scenario;
    private PipeManager pipes;
    private Passaro bird;
    private boolean gameOver;
    private Hitbox gameBox;
    private int score;
    private Timer groundTimer;
    private Timer movePipes;
    private Timer addPipes;
    private Timer removePipes;
    private Timer moveBird;
    private Timer flapWings;

    public FlappyBird()
    {
        this.startGame();
    }

    public void startGame()
    {
        this.scenario = new Scenario(this.spritesFile);
        this.pipes = new PipeManager(this);
        this.bird = new Passaro();;
        this.gameOver = false;
        this.gameBox = new Hitbox(0, 0, this.getLargura(), 400);
        this.score = 0;
        this.groundTimer = new Timer(0.015, true, this.scenario::moveGround);
        this.movePipes = new Timer(0.015, true, this.pipes::movePipes);
        this.addPipes = new Timer(4, true, this.pipes::addPipes);
        this.removePipes = new Timer(5, true, this.pipes::removePipes);
        this.moveBird = new Timer(0.03, true, this.bird::move);
        this.flapWings = new Timer(0.03, true, this.bird::flapWings);
    }

    public static void main(String[] args)
    {
	    new Motor(new FlappyBird());
    }

    @Override
    public String getTitulo()
    {
        return "Fire Bird";
    }

    @Override
    public int getLargura()
    {
        return 572;
    }

    @Override
    public int getAltura()
    {
        return 532;
    }

    @Override
    public void tique(Set<String> teclas, double dt)
    {
        if(!this.gameOver){
            this.groundTimer.tique(dt);
            this.movePipes.tique(dt);
            this.addPipes.tique(dt);
            this.removePipes.tique(dt);
            this.flapWings.tique(dt);
        }
        this.moveBird.tique(dt);
        Hitbox birdHitbox = this.bird.getHitbox();
        if(this.pipes.checkCollision(birdHitbox) || this.checkGameBoxCollision(birdHitbox)) this.gameOver = true;
        if(this.pipes.givePoint(this.bird)) score++;
    }

    @Override
    public void tecla(String tecla)
    {
        if(!this.gameOver)
            if(tecla.equals(" ")) this.bird.fly();

        if(tecla.equals("r")) this.reset();
    }

    @Override
    public void desenhar(Tela tela)
    {
        this.scenario.drawBackground(tela);
        this.pipes.drawPipes(tela, this.spritesFile);
        this.scenario.drawGround(tela);
        this.bird.draw(tela, this.spritesFile);
        this.drawScore(tela);
    }

    public boolean checkGameBoxCollision(Hitbox birdHitbox)
    {
        return this.gameBox.intersecao(birdHitbox) == 0;
    }

    public void drawScore(Tela canvas)
    {
        int thousands = this.score / 1000 % 10;
        int hundreds = this.score / 100 % 10;
        int tens = this.score / 10 % 10;
        int units = this.score % 10;

        int halfGameWidth = this.getLargura() / 2;
        Numbers.draw(canvas, this.spritesFile, halfGameWidth + 30, units);
        Numbers.draw(canvas, this.spritesFile, halfGameWidth + 10, tens);
        Numbers.draw(canvas, this.spritesFile, halfGameWidth - 10 , hundreds);
        Numbers.draw(canvas, this.spritesFile, halfGameWidth - 30, thousands);
    }

    public void reset()
    {
        this.startGame();
    }
}
