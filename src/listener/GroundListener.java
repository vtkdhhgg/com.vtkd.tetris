package listener;

import entities.Ground;

/**
 * 地面监听器
 *
 * @version 1.0 2022.6.10
 *
 * @author 君上
 *
 */
public interface GroundListener {

    /**
     * 将要消行事件
     *
     *
     * @param ground
     * @param lineNum 将要消除的行的行号
     */
    void beforeDeleteFullLine(Ground ground, int lineNum);

    /**
     * 消除满行事件
     *
     * @param ground
     * @param deleteLineCount 本次消除的行数
     */
    void fullLineDeleted(Ground ground, int deleteLineCount);

    void groundIsFull(Ground ground);

}
