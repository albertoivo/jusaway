import { JusawayWebPage } from './app.po';

describe('jusaway-web App', () => {
  let page: JusawayWebPage;

  beforeEach(() => {
    page = new JusawayWebPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!');
  });
});
