import { registerPlugin } from '@capacitor/core';

import type { IntentSenderPlugin } from './definitions';

const IntentSender = registerPlugin<IntentSenderPlugin>('IntentSender', {
  web: () => import('./web').then(m => new m.IntentSenderWeb()),
});

export * from './definitions';
export { IntentSender };
