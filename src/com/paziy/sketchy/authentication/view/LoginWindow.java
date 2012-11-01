package com.paziy.sketchy.authentication.view;

import com.paziy.sketchy.authentication.model.AuthInfo;
import com.paziy.sketchy.authentication.model.Authenticator;

public class LoginWindow implements Authenticator {

	//protected Shell shlAuthentification;
	private AuthInfo result;

	/**
	 * Open the dialog.
	 * @return the result
	 */
	private AuthInfo open() {
		createContents();
		/*shlAuthentification.open();
		shlAuthentification.layout();
		Display display = Display.getDefault();
		
		while (!shlAuthentification.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}   */
		
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		/*shlAuthentification = new Shell(SWT.MIN | SWT.TITLE);
		shlAuthentification.setSize(450, 300);
		shlAuthentification.setText("Authenticator");
		shlAuthentification.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		final Browser browser = new Browser(shlAuthentification, SWT.NONE);
		
		try {
			browser.setUrl(VKUrlManager.authorization().toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		browser.addLocationListener(new LocationListener() {
			
			@Override
			public void changing(LocationEvent event) {				
			}
			
			@Override
			public void changed(LocationEvent event) {
				if (event.location.contains("access_token")) {
					Pattern g = Pattern.compile("https://oauth.vk.com/blank.html#access_token=([0-9a-z]{1,})&expires_in=([0-9]{1,})&user_id=([0-9]{1,})");
					Matcher matcher = g.matcher(event.location);
					
					if (matcher.matches()) {
						result = new AuthInfo(matcher.group(1), matcher.group(3), matcher.group(2));
						shlAuthentification.dispose();
					}
					
				}
			}
		});   */
	}

    @Override
    public AuthInfo login() {
        return open();
    }

    @Override
    public void logout() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
