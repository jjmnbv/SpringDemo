package com.baobaotao.ioc;

/**
 * Created by 20150610 on 2016/3/30.
 */

/**
 * 剧本
 */
public class MoAttack {
    private GeLi geli;
    public MoAttack(GeLi geLi){
        this.geli = geLi;
    }
    public void cityGateAsk(){
        //引用革离角色
//        GeLi geli = new LiuDeHua();
        geli.responseAsk("墨者革离！");
    }
}
