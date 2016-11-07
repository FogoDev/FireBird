package com.fogodev.firebird;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Criado por ericson em 20/10/16.
 *
 * https://github.com/fogodev
 */
public class PipeManager
{
    private List<Cano> pipes = new ArrayList<>();
    private Cano pipeToRemove;
    private Random random = new Random();
    private Jogo game;
    private boolean alreadyGavePoint = false;

    public PipeManager(Jogo game)
    {
        this.game = game;
        this.addPipes();
    }

    public void addPipes()
    {
        this.pipes.add(new Cano(600, this.random.nextInt(150) + 80, this.game));
    }

    public void removePipes()
    {
        Cano pipeRemoveCandidate = pipes.get(0);
        if(pipeRemoveCandidate.getPosX() + pipeRemoveCandidate.getWidth() < 0) this.pipes.remove(pipeRemoveCandidate);
    }

    public void drawPipes(Tela canvas, String spriteFileName)
    {
        for(Cano pipe : PipeManager.this.pipes){
            pipe.draw(canvas, spriteFileName);
        }
    }

    public void movePipes()
    {
        for(Cano pipe : this.pipes){
            pipe.move();
        }
    }

    public boolean checkCollision(Hitbox hitbox)
    {
        for(Cano pipe : this.pipes){
            if(pipe.checkCollision(hitbox)) return true;
        }
        return false;
    }

    public boolean givePoint(Passaro bird)
    {
        Cano firstPipe = this.pipes.get(0);
        if(firstPipe.getPosX() + firstPipe.getWidth() == bird.getPosX()){
            if(!this.alreadyGavePoint) {
                this.alreadyGavePoint = true;
                return true;
            } else {
                return false;
            }
        } else {
            this.alreadyGavePoint = false;
            return false;
        }
    }
}
