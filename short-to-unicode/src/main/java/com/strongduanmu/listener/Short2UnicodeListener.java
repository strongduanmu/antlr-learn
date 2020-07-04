package com.strongduanmu.listener;

import com.strongduanmu.ArrayInitBaseListener;
import com.strongduanmu.ArrayInitParser;

/**
 * Desc: Short转Unicode监听器
 * Date: 2020/6/29
 *
 * @author duanzhengqiang
 */
public class Short2UnicodeListener extends ArrayInitBaseListener {

    @Override
    public void enterInit(ArrayInitParser.InitContext ctx) {
        System.out.print("\"");
    }

    @Override
    public void exitInit(ArrayInitParser.InitContext ctx) {
        System.out.print("\"");
    }

    @Override
    public void enterValue(ArrayInitParser.ValueContext ctx) {
        int value = Integer.parseInt(ctx.INT().getText());
        System.out.printf("\\u%04x", value);
    }
}
