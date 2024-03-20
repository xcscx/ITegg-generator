package com.itegg.cli.pattern;

/**
 * 开启按钮
 */
public class TurnOnCommand implements  Command{
    private Device device;

    public TurnOnCommand(Device device) {
        this.device = device;
    }

    public void execute() {
        device.turnOn();
    }

}
