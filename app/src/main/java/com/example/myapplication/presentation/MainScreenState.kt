package com.example.myapplication.presentation

/**
 * Класс для описания состояния экрана
 */
sealed class MainScreenState: IScreenState {

    /**
     * Режим загрузки (показывается анимация загрузки)
     */
    object Loading: MainScreenState()

    /**
     * Режим отображения ошибки.
     * @param e ошибка. Ее текст отображается с кнопкой "Повторить"
     */
    class Error(e: Throwable): MainScreenState()

    /**
     * Рабочий режим с отображением загруженного списка
     */
    class Working(): MainScreenState()
}
