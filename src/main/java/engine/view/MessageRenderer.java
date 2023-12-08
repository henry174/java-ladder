package engine.view;

public class MessageRenderer {

    /** 컬럼 간 간격 */
    private static final int COLUMN_WIDTH = 6;

    private static final char CONNECTION_SYMBOL = '-';
    private static final char COLUMN_SYMBOL = '|';

    private MessageRenderer() {
    }

    /**
     * 주어진 문자열을 출력합니다.
     *
     * @param message 출력할 메세지
     * @param isEndLine 이 메세지가 라인의 끝인지를 설정합니다. true면 줄바꿈하고 그 다음 출력부터는 다음 라인에 출력됩니다.
     */
    public static void simplePrint(String message, boolean isEndLine) {
        if (isEndLine) {
            System.out.println(message);
            return;
        }

        System.out.print(message);
    }

    /**
     * 주어진 문자열을 출력하고 줄바꿈합니다.
     *
     * @param message 출력할 메세지
     */
    public static void simplePrint(String message) {
        simplePrint(message, true);
    }

    /**
     * 개행합니다.
     */
    public static void newLine() {
        simplePrint("", true);
    }


    /**
     * 특정 길이의 공간을 잡고 그 안에서 프린트합니다.
     * 출력 문자열 간 정렬을 할 때 사용할 수 있습니다.
     *
     * @param printableSting 출력 문자열
     * @param width 잡을 길이
     * @param isEndLine 이 라인에서 마지막 출력인지를 나타냅니다. true면 줄바꿈합니다.
     */
    public static void simplePrintWithWidth(String printableSting, int width, boolean isEndLine) {
        StringBuilder spacing = new StringBuilder();

        for (int i = 0; i < width - printableSting.length(); i++) {
            spacing.append(' ');
        }

        simplePrint(printableSting + spacing.toString(), isEndLine);
    }

    /**
     * 특정 길이의 공간을 잡고 그 안에서 프린트합니다.
     * 줄바꿈을 하지 않습니다.
     *
     * @param printableSting 출력 문자열
     * @param width 잡을 길이
     */
    public static void simplePrintWithWidth(String printableSting, int width) {
        simplePrintWithWidth(printableSting, width, false);
    }

}