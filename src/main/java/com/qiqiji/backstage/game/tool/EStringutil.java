package com.qiqiji.backstage.game.tool;

public enum EStringutil {
    /**
     * 用枚举设计单例模式！
     */
    INSTANCE;

    //非空判断
    public boolean IsEmpty(String str) {
        return str != null && !"".equals(str.trim());
    }
}
