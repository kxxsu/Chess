package chess;

public enum Status {
    START, // 1
    ONE_PICKED, // 1.1

    CONNECTED, // 1
    COLORS_ASSIGNED, // 1.1
    START_GAME, // 2
    ACTIVE_WHITE, // 2.1
    ACTIVE_BLACK, // 2.2
    WHITE_DRAW_REQUEST, // 3
    WHITE_DRAW_DENY, // 3.1 // TODO: 14.12.2020 implement block to Draw Request after opponent denies
    BLACK_DRAW_REQUEST, // 3
    BLACK_DRAW_DENY, // 3.1

    DRAW, // 3.2
    WHITE_RESIGNED, // 4
    BLACK_RESIGNED, // 4
    WHITE_WIN, // 5
    BLACK_WIN, // 5

    ENDED, // 6

}
