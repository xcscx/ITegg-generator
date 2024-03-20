package com.itegg.cli.pattern;

/**
 * 关闭 按钮
 */
public class TurnOffCommand implements  Command{
    private Device device;

    public TurnOffCommand(Device device) {
        this.device = device;
    }

    public void execute() {
        device.turnOff();
    }

}
