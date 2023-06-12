{{/*
Generate labels
*/}}

{{- define "post-chart.labels" -}}
  labels:
    app: {{ .Chart.Name }}
    release: {{ .Release.Name }}
    date: {{ now | htmlDate }}
    version: {{ .Chart.Version }}
    environment: {{ .Values.namespace }}
{{- end -}}

