package com.fogodev.firebird;

/**
 * Criado por ericson em 19/10/16.
 *
 * https://github.com/fogodev
 */
public class Passaro
{
    private double posY = 100;
    private double posX = 100;
    private double speedY = 0;
    private int width = 34;
    private int height = 24;
    private boolean fly = false;
    private int changeSprite = 0;
    private double angle = 0;
    private Hitbox hitbox = new Hitbox(this.posX, this.posY, this.posX + this.width, this.posY + this.height);

    public void draw(Tela canvas, String spriteFileName)
    {
        if(this.changeSprite >= 9) this.changeSprite = 0;
        switch (this.changeSprite % 3){
            case 0:
                canvas.imagem(spriteFileName, 527, 129, this.width, this.height, this.angle, this.posX, this.posY);
                break;
            case 1:
                canvas.imagem(spriteFileName, 527, 180, this.width, this.height, this.angle, this.posX, this.posY);
                break;
            case 2:
                canvas.imagem(spriteFileName, 446, 248, this.width, this.height, this.angle, this.posX, this.posY);
                break;
        }
    }

    public void fly()
    {
        this.fly = true;
        this.angle -= Math.PI * 0.6;
        if(this.angle < -Math.PI / 4) this.angle = -Math.PI / 4;
    }

    public void move()
    {
        this.speedY = this.fly ?  -10  : ++this.speedY;
        this.posY += this.speedY;
        if(this.posY > 420) this.posY = 410;
        this.angle += Math.PI * 0.025;
        if(this.angle > Math.PI / 2) this.angle = Math.PI / 2;
        if(this.fly) this.fly = !this.fly;
        this.hitbox.mover(this.posX, this.posY, this.posX + this.width, this.posY + this.height);
    }

    public Hitbox getHitbox()
    {
        return this.hitbox;
    }

    public void flapWings()
    {
        this.changeSprite++;
    }

    public double getPosX()
    {
        return this.posX;
    }
}
