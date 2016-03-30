package com.baobaotao.ioc;

/**
 * Created by 20150610 on 2016/3/30.
 * 导演
 */
public class Director {
    //导演控制剧本角色的演员
    public void direct(){
        GeLi geLi = new LiuDeHua();
        MoAttack moAttack = new MoAttack(geLi);
        moAttack.cityGateAsk();

    }
    public static void main(String args[]){
        Director director = new Director();
        director.direct();
    }
}
