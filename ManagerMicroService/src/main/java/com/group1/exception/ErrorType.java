package com.group1.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {
    INTERNAL_ERROR(5100,"Sunucu Hatasi...", HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST(4100,"Parametre Hatasi...", HttpStatus.BAD_REQUEST),
    LOGIN_ERROR(4110,"Kullanici adi veya sifre hatali...", HttpStatus.BAD_REQUEST),
    USERNAME_DUPLICATE(4111,"Kullanici adi kullanilmaktadir" ,HttpStatus.BAD_REQUEST),
    MANAGER_NOT_FOUND(4112,"Manager bulunamadi..." , HttpStatus.BAD_REQUEST ),
    ACTIVATION_CODE_ERROR(4113,"Aktivasyon kodu hatalidir..." , HttpStatus.BAD_REQUEST ),
    INVALID_TOKEN(4114,"Gecersiz token" ,HttpStatus.BAD_REQUEST),
    TOKEN_NOT_CREATED(4115,"Token olusturulamadi..." ,HttpStatus.BAD_REQUEST ),
    ACCOUNT_NOT_ACTIVE(4116,"Hesabınız aktif edilmemiştir. Lütfen hesabınızı aktif hale getiriniz..." , HttpStatus.FORBIDDEN),
    USER_NOT_CREATED(4117,"Kullanici profili olusturulamadi...",HttpStatus.BAD_REQUEST),
    ROLE_NOT_FOUND(4118,"Boyle bir kullanici rolu bulunmamaktadir..." ,HttpStatus.BAD_REQUEST ),
    SPENDING_NOT_FOUND(4119,"Harcama oluşturulamadı",HttpStatus.BAD_REQUEST),
    ADVANCE_NOT_FOUND(4120,"Avans oluşturulamadı",HttpStatus.BAD_REQUEST),
    AUTHORITY_IS_NOT_ENOUGH(4121,"Yetki Yeterli Değil",HttpStatus.BAD_REQUEST),
    Item_Not_Found(4122,"İstenilen Zimmet Bulunamadı" ,HttpStatus.BAD_REQUEST );

    private int code;
    private String message;
    private HttpStatus httpStatus;
}
