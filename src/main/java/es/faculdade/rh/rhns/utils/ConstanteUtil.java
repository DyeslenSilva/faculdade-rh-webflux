package es.faculdade.rh.rhns.utils;

import es.faculdade.rh.rhns.utils.model.UrlNotification;
import es.faculdade.rh.rhns.utils.model.UtilLibJava;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class ConstanteUtil {

	private static UrlNotification notification;
	private static UtilLibJava libJava;
	
	public static final String REFERENCE_LIB_JAVA = libJava.getLibJavaDirectPayment();
	public static final String URL_NOTIFICATION = notification.getUrlNotification();
	
	
}
