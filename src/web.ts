import { WebPlugin } from '@capacitor/core';

import type { IntentSenderPlugin } from './definitions';

export class IntentSenderWeb extends WebPlugin implements IntentSenderPlugin {

    startActivity(): Promise<void> {
        throw this.unimplemented('Not implemented on web');
    }
}
