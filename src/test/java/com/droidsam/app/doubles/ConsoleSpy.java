package com.droidsam.app.doubles;

import java.io.PrintStream;

public class ConsoleSpy extends PrintStream {
    private String printedString;

    public ConsoleSpy() {
        super(System.out);
    }

    @Override
    public void println(String s) {
        this.printedString = s;
        super.print(s);
    }

    public String getPrintedString() {
        return printedString;
    }
}
