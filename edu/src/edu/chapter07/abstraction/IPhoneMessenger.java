package edu.chapter07.abstraction;

public class IPhoneMessenger extends GraphicIOS implements Messenger, WorkFile {

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "iPhone";
	}

	@Override
	public void setMessage(String msg) {
		// TODO Auto-generated method stub
		System.out.println("iPhone에서 메시지를 설정합니다 : " + msg);
	}
	
	public void clearMessage() {
		System.out.println("좌우로 흔들어 문자열을 지웁니다.");
	}

	@Override
	public void fileUpload() {
		// TODO Auto-generated method stub
		System.out.println("file 업로드!");
	}

	@Override
	public void fileDownload() {
		// TODO Auto-generated method stub
		System.out.println("file 다운로드!");
	}

	@Override
	public void draw_textBox() {
		// TODO Auto-generated method stub
		super.draw_textBox();
		System.out.println("IPhoneMessenger : 텍스트 상자를 그린다.");
	}

	@Override
	public void draw_submitButton() {
		// TODO Auto-generated method stub
		super.draw_submitButton();
		System.out.println("IPhoneMessenger : 전송 버튼을 그린다.");
	}

}
