package ValidationData;

import Exception.ValueOutOfRangeException;

public class ValidationNumber {
    public void validationListTextStyles(int number) throws ValueOutOfRangeException {
        if (number < 0 || number > 5) {
            throw new ValueOutOfRangeException("Значение находится вне допустимого диапазона (1-4) ваше число : " + number);
        }
    }

    public void validationSelectTextLocation(int number) throws ValueOutOfRangeException {
        if (number < 0 || number > 10) {
            throw new ValueOutOfRangeException("Значение находится вне допустимого диапазона (1-9) ваше число : " + number);
        }
    }

    public void textSizeValidation(int size) throws ValueOutOfRangeException {
        if (size <= 0) {
            throw new ValueOutOfRangeException("Размер текста не может быть мешьше 1");
        }
    }

    public void selectedCodeValidation(int number) throws ValueOutOfRangeException {
        if (number < 0 || number > 3) {
            throw new ValueOutOfRangeException("Значение находится вне допустимого диапазона (1-2) ваше число : " + number);
        }
    }
}

