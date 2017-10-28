import { AngularstarterPage } from './app.po';

describe('angularstarter App', function() {
  let page: AngularstarterPage;

  beforeEach(() => {
    page = new AngularstarterPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
