package com.illdangag.string;

public class BuilderBufferMain {
    public static void main(String[] args) {
        int range = 1_000_000; // 100_000, 1_000_000, 10_000_000, 100_000_000
        int repeat = 5;

        long startTime = 0;
        long endTime = 0;
        long stringExecuteTime = 0;
        long bufferExecuteTime = 0;
        long builderExecuteTime = 0;

        for (int repeatIndex = 0; repeatIndex < repeat; repeatIndex++) {
            startTime = System.nanoTime();
            String string = "";
            for (int index = 0; index < range; index++) {
                string += "O";
            }
            endTime = System.nanoTime();
            stringExecuteTime += (endTime - startTime);
            System.out.println("string length: " + string.length());

            startTime = System.nanoTime();
            StringBuffer stringBuffer = new StringBuffer();
            for (int index = 0; index < range; index++) {
                stringBuffer.append("O");
            }
            String bufferResult = stringBuffer.toString();
            endTime = System.nanoTime();
            bufferExecuteTime += (endTime - startTime);
            System.out.println("StringBuffer length: " + bufferResult.length());

            startTime = System.nanoTime();
            StringBuilder stringBuilder = new StringBuilder();
            for (int index = 0; index < range; index++) {
                stringBuilder.append("O");
            }
            String builderResult = stringBuilder.toString();
            endTime = System.nanoTime();
            builderExecuteTime += (endTime - startTime);
            System.out.println("StringBuilder length: " + builderResult.length());
        }

        stringExecuteTime /= repeat;
        bufferExecuteTime /= repeat;
        builderExecuteTime /= repeat;

        System.out.printf("String: %f ms\n", (stringExecuteTime / 1000000D));
        System.out.printf("StringBuffer: %f ms\n", (bufferExecuteTime / 1000000D));
        System.out.printf("StringBuilder: %f ms\n", (builderExecuteTime / 1000000D));
    }
}
