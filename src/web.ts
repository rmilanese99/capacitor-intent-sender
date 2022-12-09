import { WebPlugin } from '@capacitor/core';

import type { IntentSenderPlugin } from './definitions';

export class IntentSenderWeb extends WebPlugin implements IntentSenderPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
