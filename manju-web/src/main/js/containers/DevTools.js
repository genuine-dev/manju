import React from 'react'
import { createDevTools } from 'redux-devtools'
import DockMonitor from 'redux-devtools-log-monitor'
import LogMonitor from 'redux-devtools-log-monitor'

const DevTools = createDevTools(
  <DockMonitor toggleVisibilityKey='ctrl-h' changePositionKey='ctrl-w'>
    <LogMonitor />
  </DockMonitor>
)

export default DevTools
